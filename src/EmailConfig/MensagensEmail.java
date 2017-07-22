package EmailConfig;

import DAO.ClienteDAO;

/**
 *
 * @author HP
 */
public class MensagensEmail {

    private String mensagensAdicionais = "\n Em alguns casos pode aparecer as seguintes mensagens:\n "
            + "\n\"Certificado de servidor não confiável\" - caso ocorra, reinicie o computador. Se persistir o probrema, desinstale o antivirus e instale novamente.\n"
            + "\n\"Você excedeu o limite de ativações\" - neste caso, entre em contato conosco para desbloquearmos o código. \n"
            + "\n\"Código inválido\" - neste caso você está inserindo algum caracter do código errado. Sugerimos copiar e colar o código na primeira caixa de texto na tela de ativação.";

    public String verificaQualOCorpoDOEmail(String tipo, int qtdDispositivos, String codigo, int qtdVenda) {
        switch (tipo.toLowerCase()) {
            case "total":
                return corpoTotal(qtdDispositivos, codigo);
            case "kis":
            case "kis promocional":
                return corpoKIS(qtdDispositivos, codigo);
            case "android":
                return corpoKIS(qtdDispositivos, codigo);
            case "small":
                return corpoSMALL(qtdDispositivos, codigo, qtdVenda);
            default:
                return null;
        }
    }

    public String corpoTotal(int qtd, String codigo) {

        return "Segue seu(s) código(s). Não ative em mais que o informado ao lado senão poderá haver bloqueio. Após ativação, efetue a qualificação da venda.\n"
                + "\n"
                + "Código de ativação: " + codigo + "\n"
                + "\n"
                + " Total 2017 versão português Windows: http://products.kaspersky-labs.com/portuguese/homeuser/kts2017/kts17.0.0.611pt_11117.exe"
                + "\nVersão MAC, iPhone e Android: https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial"
                + "\n\n\nKaspersky Total Security – multidispositivos 2017 é a solução de segurança fácil de usar com uma licença para diversas plataformas que protege praticamente qualquer tipo de PC, Mac, smartphone Android e tablet Android contra malwares, criminosos virtuais e ameaças da Internet. Independentemente do tipo de dispositivo que você usa, a Kaspersky pode protegê-los: e as informações sigilosas armazenadas neles. \n"
                + "\n"
                + mensagensAdicionais
                + "\nCaso você não tenha o Kaspersky Total Security – multidispositivos 2017 instalado no seu dispositivo, faça o download do arquivo de instalação informado acima..\n"
                + "\n"
                + "Somente será necessário ativar o produto com o CÓDIGO DE ATIVAÇÃO se você já estiver utilizando a versão de teste do Kaspersky Total Security – multidispositivos 2017. A reinstalação não é necessária. \n"
                + "\n"
                + "Recomendamos também que você salve o código de ativação para obter acesso gratuito ao nosso suporte da loja ou da KasperskyLab, disponível durante o período de validade da licença do produto. \n"
                + "\n"
                + "Esperamos que você fique satisfeito com seu novo produto e oferecemos àqueles que já são nossos clientes um desconto nas renovações de licença.\n";
    }

    public String corpoKIS(int qtd, String codigo) {

        return "Segue seu(s) código(s). Não ative em mais de o informado ao lado senão poderá haver bloqueio. Após ativação, efetue a qualificação da venda.\n"
                + "\n"
                + "Código(s) de ativação: " + codigo + "\n"
                + "\n"
                + "KIS 2017 versão português: http://products.kaspersky-labs.com/portuguese/homeuser/kis2017/kis17.0.0.611pt_11260.exe\n"
                + "Versão MAC, iPhone e Android: https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial"
                + "\n"
                + mensagensAdicionais
                + "\nKaspersky Internet Security – multidispositivos 2017 é a solução de segurança fácil de usar com uma licença para diversas plataformas que protege praticamente qualquer tipo de PC, Mac, smartphone Android e tablet Android contra malwares, criminosos virtuais e ameaças da Internet. Independentemente do tipo de dispositivo que você usa, a Kaspersky pode protegê-los: e as informações sigilosas armazenadas neles. \n"
                + "\n"
                + "Caso você não tenha o Kaspersky Internet Security – multidispositivos 2017 instalado no seu dispositivo, faça o download do arquivo de instalação informado acima..\n"
                + "\n"
                + "Somente será necessário ativar o produto com o CÓDIGO DE ATIVAÇÃO se você já estiver utilizando a versão de teste do Kaspersky Internet Security – multidispositivos 2017. A reinstalação não é necessária. \n"
                + "\n"
                + "Recomendamos também que você salve o código de ativação para obter acesso gratuito ao nosso suporte da loja ou da KasperskyLab, disponível durante o período de validade da licença do produto. \n"
                + "\n"
                + "Esperamos que você fique satisfeito com seu novo produto e oferecemos àqueles que já são nossos clientes um desconto nas renovações de licença.\n";
    }

    public String corpoSMALL(int qtd, String codigo, int servidor) {

        return "Não ative seu(s) código(s) em mais dipositivos que o informado ao lado senão o seu código será bloqueado. Após ativação, efetue a qualificação da venda.\n"
                + "\n"
                + "Código de ativação: " + codigo + "\n"
                + "Versão 2017: http://brazil.kaspersky.com/downloads/versoes-de-teste/small-office-security \n"
                + "\n\nLEIA COM ATENÇÃO:\n"
                + "Este email contém seu código de ativação. Salve-o ou imprima-o e o guarde em um lugar seguro.\n"
                + "\n"
                + mensagensAdicionais
                + "\n"
                + "Se você estiver usando a versão de avaliação do produto que comprou\n"
                + "1. Clique com o botão direito do mouse no ícone \"K\" do Kaspersky no canto inferior direito da área de trabalho.\n"
                + "2. Clique em \"Ativar\".\n"
                + "3. Siga as instruções para ativar o software. (Clique aqui para obter orientações detalhadas).\n"
                + "\n"
                + "Instruções Gerais de Instalação\n"
                + "Antes de iniciar a instalação de seu novo software da Kaspersky Lab, remova todos os softwares antivírus e antispyware instalados no computador. Se tiver dificuldades ao desinstalar softwares de terceiros, há ferramentas de remoção disponíveis aqui. Ao concluir esse procedimento, execute as etapas a seguir:\n"
                + "\n"
                + "1.	Caso você ainda não tenha baixado a versão mais recente do Kaspersky Small Office Security, faça-o agora. Selecione o idioma correto da versão mais recente. Você também pode baixar o arquivo de instalação de todos os nossos produtos a qualquer momento em:\n"
                + "http://brazil.kaspersky.com/downloads/atualizacoes-de-produtos\n"
                + "2.	Salve o arquivo no computador. Ao concluir o download,\n"
                + "Usuários do XP: clique duas vezes no arquivo para iniciar a instalação.\n"
                + "Usuários do Vista ao Windows 10: clique com o botão direito do mouse no arquivo gravado e selecione \"Executar como administrador\".\n"
                + "3.	Siga as instruções na tela e, quando solicitado, insira seu código de ativação. É necessário ter uma conexão com a Internet durante a ativação.\n"
                + "4.	Reinicie o computador para concluir a instalação.\n"
                + "Instruções Detalhadas de Instalação \n"
                + "Se desejar instruções mais detalhadas sobre como instalar e ativar o software, incluindo perguntas frequentes e suas soluções, visite:\n"
                + "\n"
                + "http://brazil.kaspersky.com/comprar/como-instalar-kaspersky-small-office-security\n";
    }

    public String mensagemIncidenteAdicionado(String nome) {

        
        String s = "Caro(a) " + nome + ", recebemos seu incidente e iremos solucioná-lo o mais rápido possível. Aguarde nosso retorno, em breve responderemos!";
        return s;
    }

    public String mensagemIncidenteEncerrado(String nome, int motivo, String codigo) {

        String s = "Caro(a) " + nome + ", seu incidente foi encerrado em nosso sistema.";
        if (motivo == 1 || motivo == 2) {
            s = s + "\nVocê já pode utilizar o seu código '" + codigo + "' novamente. Em caso de outros problemas, entre em contato novamente, estamos dispostos a atendê-lo!";
        }
        else if (motivo == 3) {
            s = s + "\n\nSeu código foi substituído. Siga os seguintes passos abaixo:Passo 1 - Eliminar as licenças:\n"
                    + "Abra o Kaspersky \n"
                    + "Clique na licença no canto inferior direito da janela.\n"
                    + "Clique no X no lado direito do número de licença/chave.\n"
                    + "Se você não vê um X na parte superior, clique na seta no centro da janela, depois, clique no \"X\" ou \"excluir codigo predefinido\".\n"
                    + "Clique em Sim para excluir a licença.\n"
                    + "Se você ver um outro X, clique nele e clique em Sim para excluir a licença.\n"
                    + "Você será avisado o aplicativo não está ativado.\n"
                    + "Reinicie o seu PC\n"
                    + "Passo 2 - Reativar:\n"
                    + "Abra o Kaspersky \n"
                    + "Clique em \"licença\" no canto inferior direito da janela.\n"
                    + "Clique em \"Ativar o aplicativo\" ou \"inserir o codigo de ativação\"\n"
                    + "Digite o código de ativação apenas no numero de dispositivos conforme a sua compra: \n"
                    + codigo + "\n"
                    + "Clique em Avançar e aguarde o processo para ser executado.\n"
                    + "Clique em Concluir.\n"
                    + "Clique em Fechar";
        }
        else if(motivo == 4){
             s = s + "\nCaso o problema ainda persista, entre em contato imediatamente conosco.";
        }
        return s;
    }
}
