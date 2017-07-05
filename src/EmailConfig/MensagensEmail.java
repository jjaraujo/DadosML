package EmailConfig;

/**
 *
 * @author HP
 */
public class MensagensEmail {

    public String verificaQualOCorpoDOEmail(String tipo, int qtd, String codigo) {
        switch (tipo.toLowerCase()) {
            case "total":
                return corpoTotal(qtd, codigo);
            case "kis":
                return corpoKIS(qtd, codigo);
            case "android":
                return corpoKIS(qtd, codigo);
            case "small":
                return corpoSMALL(qtd, codigo);
            default:
                return null;
        }
    }

    public String corpoTotal(int qtd, String codigo) {
        String dispositivos = null;
        if (qtd == 1) {
            dispositivos = "1 dispositivo";
        } else {
            dispositivos = qtd + " dispositivos";
        }

        return "Segue seu código para " + dispositivos + ". Não ative em mais de " + qtd + " senão o seu código será bloqueado. Após ativação, efetue a qualificação da venda.\n"
                + "\n"
                + "Código de ativação: " + codigo + "\n"
                + "\n"
                + " Total 2017 versão português Windows: http://products.kaspersky-labs.com/portuguese/homeuser/kts2017/kts17.0.0.611pt_11117.exe"
                + "\n\nKaspersky Total Security – multidispositivos 2017 é a solução de segurança fácil de usar com uma licença para diversas plataformas que protege praticamente qualquer tipo de PC, Mac, smartphone Android e tablet Android contra malwares, criminosos virtuais e ameaças da Internet. Independentemente do tipo de dispositivo que você usa, a Kaspersky pode protegê-los: e as informações sigilosas armazenadas neles. \n"
                + "Versão MAC, iPhone e Android: https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial"
                + "\n"
                + "Caso você não tenha o Kaspersky Total Security – multidispositivos 2017 instalado no seu dispositivo, faça o download do arquivo de instalação informado acima..\n"
                + "\n"
                + "Somente será necessário ativar o produto com o CÓDIGO DE ATIVAÇÃO se você já estiver utilizando a versão de teste do Kaspersky Total Security – multidispositivos 2017. A reinstalação não é necessária. \n"
                + "\n"
                + "Recomendamos também que você salve o código de ativação para obter acesso gratuito ao nosso suporte da loja ou da KasperskyLab, disponível durante o período de validade da licença do produto. \n"
                + "\n"
                + "Esperamos que você fique satisfeito com seu novo produto e oferecemos àqueles que já são nossos clientes um desconto nas renovações de licença.\n";
    }

    public String corpoKIS(int qtd, String codigo) {
        String dispositivos = null;
        if (qtd == 1) {
            dispositivos = "1 dispositivo";
        } else {
            dispositivos = qtd + " dispositivos";
        }

        return "Segue seu código para " + dispositivos + ". Não ative em mais de " + qtd + " senão o seu código será bloqueado. Após ativação, efetue a qualificação da venda.\n"
                + "\n"
                + "Código de ativação: " + codigo + "\n"
                + "\n"
                + "KIS 2017 versão português: http://products.kaspersky-labs.com/portuguese/homeuser/kis2017/kis17.0.0.611pt_11260.exe\n"
                + "Versão MAC, iPhone e Android: https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial"
                + "\n"
                + "Kaspersky Internet Security – multidispositivos 2017 é a solução de segurança fácil de usar com uma licença para diversas plataformas que protege praticamente qualquer tipo de PC, Mac, smartphone Android e tablet Android contra malwares, criminosos virtuais e ameaças da Internet. Independentemente do tipo de dispositivo que você usa, a Kaspersky pode protegê-los: e as informações sigilosas armazenadas neles. \n"
                + "\n"
                + "Caso você não tenha o Kaspersky Internet Security – multidispositivos 2017 instalado no seu dispositivo, faça o download do arquivo de instalação informado acima..\n"
                + "\n"
                + "Somente será necessário ativar o produto com o CÓDIGO DE ATIVAÇÃO se você já estiver utilizando a versão de teste do Kaspersky Internet Security – multidispositivos 2017. A reinstalação não é necessária. \n"
                + "\n"
                + "Recomendamos também que você salve o código de ativação para obter acesso gratuito ao nosso suporte da loja ou da KasperskyLab, disponível durante o período de validade da licença do produto. \n"
                + "\n"
                + "Esperamos que você fique satisfeito com seu novo produto e oferecemos àqueles que já são nossos clientes um desconto nas renovações de licença.\n";
    }

    public String corpoSMALL(int qtd, String codigo) {
        String dispositivos = null;
        if (qtd == 1) {
            dispositivos = "1 servidor";
        } else {
            dispositivos = qtd + " dispositivos, 1 servidor";
        }

        return "Segue seu código para " + dispositivos + ". Não ative em mais de " + qtd + " senão o seu código será bloqueado. Após ativação, efetue a qualificação da venda.\n"
                + "\n"
                + "Código de ativação: " + codigo + "\n"
                + "Versão 2017: http://brazil.kaspersky.com/downloads/versoes-de-teste/small-office-security \n"
                + "LEIA COM ATENÇÃO:\n"
                + "Este email contém seu código de ativação. Salve-o ou imprima-o e o guarde em um lugar seguro.\n"
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
                + "Usuários do Vista e Windows 7: clique com o botão direito do mouse no arquivo gravado e selecione \"Executar como administrador\".\n"
                + "3.	Siga as instruções na tela e, quando solicitado, insira seu código de ativação. É necessário ter uma conexão com a Internet durante a ativação.\n"
                + "4.	Reinicie o computador para concluir a instalação.\n"
                + "Instruções Detalhadas de Instalação \n"
                + "Se desejar instruções mais detalhadas sobre como instalar e ativar o software, incluindo perguntas frequentes e suas soluções, visite:\n"
                + "\n"
                + "http://brazil.kaspersky.com/comprar/como-instalar-kaspersky-small-office-security\n";
    }
}
