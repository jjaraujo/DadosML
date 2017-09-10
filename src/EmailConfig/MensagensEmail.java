package EmailConfig;

import Controle.VariaveisDeControle;
import DAO.ClienteDAO;
import Entidades.Produtos;
import Entidades.Vendas;

/**
 *
 * @author HP
 */
public class MensagensEmail {

    private final String mensagemDownload =  "";
    private final String linkTotal = "https://www.kaspersky.com.br/downloads/thank-you/total-security-free-trial";
    private final String linkKIS = "https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial";
    private final String linkAntivirus = "https://www.kaspersky.com.br/downloads/thank-you/antivirus-free-trial";

    public String verificaQualOCorpoDOEmailHTML(String tipo, int qtdDispositivos, String codigo, Vendas v, String nome) {
        switch (tipo.toLowerCase()) {
            case "total":
                return corpoTotalHTML(qtdDispositivos, codigo, v, nome);
            case "kis":
            case "android free":
                Produtos p = VariaveisDeControle.mapProd.get(v.getIdProduto());
                if (p.getAnos() > 1) {
                    return corpoTotalHTML(qtdDispositivos, codigo, v, nome);
                } else {
                    return corpoKISHTML(qtdDispositivos, codigo, v, nome);
                }
            case "android":
                return corpoAndroidHTML(qtdDispositivos, codigo, v, nome);
            case "antivirus":
                return corpoAntivirusHTML(qtdDispositivos, codigo, v, nome);
            case "small":
                return corpoSMALLHTML(qtdDispositivos, codigo, v, nome);
            default:
                return null;
        }
    }

    public String corpoTotalHTML(int qtd, String codigo, Vendas v, String nome) {
        String nomeProduto = VariaveisDeControle.mapProd.get(v.getIdProduto()).getNomeProduto();
        return "<p>&nbsp;</p>\n"
                + "<table style=\"height: 324px; background-color: #f5f5f5; width: 920px; float: left;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">Caro(a) " + nome + " .</span></p>\n"
                + "<p><span style=\"font-size: small;\">Obrigado pela sua compra na loja online da KSafe.</span></p>\n"
                + "<p><span style=\"font-size: small;\">Esta mensagem &eacute; um resumo do seu pedido e sugerimos que a guarde como comprovante.&nbsp;</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">N&uacute;mero do Pedido: " + v.getId() + "</span></p>\n"
                + "<p><span style=\"font-size: small;\">Forma de Pagamento: " + v.getFormaPagamento() + "</span></p>\n"
                + "<table style=\"height: 19px; background-color: #006a5a; width: 855px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td><span style=\"color: #ffffff; font-size: small;\"><strong>Nome do Produto &nbsp; &nbsp; &nbsp;&nbsp;</strong></span></td>\n"
                + "<td><strong><span style=\"color: #ffffff; font-size: small;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Qtd Comprada</span></strong></td>\n"
                + "<td><strong><span style=\"font-size: small;\"><span style=\"color: #ffffff;\">Valor &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></span></strong></td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n" // 2
                + "<p><span style=\"font-size: small;\">" + nomeProduto + " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + v.getQtd() + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; " + v.getValor() + "</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: medium; color: #ff0000;\"><strong>C&oacute;digo de ativa&ccedil;&atilde;o: " + codigo + "</strong></span></p>\n"
                + "<p><br /><br /><span style=\"font-size: small;\"><span><strong>LEIA COM ATEN&Ccedil;&Atilde;O:</strong><br /><span>Este email cont&eacute;m seu c&oacute;digo de ativa&ccedil;&atilde;o. Salve-o ou imprima-o e o guarde em um lugar seguro.</span></span></span></p>\n"
                + "<p><span style=\"font-size: small;\"><span><span><strong><span style=\"text-decoration: underline;\">Se voc&ecirc; estiver usando a vers&atilde;o de avalia&ccedil;&atilde;o do produto que comprou</span></strong><br /><span>1. Clique com o bot&atilde;o direito do mouse no &iacute;cone \"\"K\"\" do Kaspersky no canto inferior direito da &aacute;rea de trabalho.</span><br /><span>2. Clique em \"Ativar\".</span><br /><span>3. Siga as instru&ccedil;&otilde;es para ativar o software.Instru&ccedil;&otilde;es Gerais de Instala&ccedil;&atilde;o</span><br /><span>Antes de iniciar a instala&ccedil;&atilde;o de seu novo software da Kaspersky Lab, remova todos os softwares antiv&iacute;rus e antispyware instalados no computador. Se tiver dificuldades ao desinstalar softwares de terceiros, h&aacute; ferramentas de remo&ccedil;&atilde;o dispon&iacute;veis&nbsp; aqui</span><a href=\"http://support.kaspersky.com/us/consumer/tools-utilities\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?hl=pt-BR&amp;q=http://support.kaspersky.com/us/consumer/tools-utilities&amp;source=gmail&amp;ust=1504486321478000&amp;usg=AFQjCNFNa17k1r0E1qJQmwjgWCr-9hPMOA\">aqui</a><span>. Ao concluir esse procedimento, execute as etapas a seguir:</span></span></span></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><span><span><span><span>Caso voc&ecirc; ainda n&atilde;o tenha baixado a vers&atilde;o mais recente do Kaspersky Total Security, fa&ccedil;a-o agora. <span><strong>Kasperksy Total Security 2018 vers&atilde;o portugu&ecirc;s Windows</strong>: " + linkTotal + " <strong>" + mensagemDownload + ". &nbsp;</strong></span></span></span></span></span></span></li>\n"
                + "<li><span style=\"font-size: small;\">Voc&ecirc; tamb&eacute;m pode baixar o arquivo de instala&ccedil;&atilde;o das vers&otilde;es MAC, iPhone e Android: <a href=\"https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial\">https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial</a></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Salve o arquivo no computador. </span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Siga as instru&ccedil;&otilde;es na tela e, quando solicitado, insira seu c&oacute;digo de ativa&ccedil;&atilde;o. &Eacute; necess&aacute;rio ter uma conex&atilde;o com a Internet durante a ativa&ccedil;&atilde;o.</span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Reinicie o computador para concluir a instala&ccedil;&atilde;o.&nbsp;</span></span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"text-decoration: underline;\"><strong><span style=\"font-size: small;\">Em alguns casos pode aparecer as seguintes mensagens:</span></strong></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><strong>Certificado de servidor n&atilde;o confi&aacute;vel</strong> - caso ocorra, reinicie o computador. Se persistir o probrema, desinstale o antivirus e instale novamente.</span></li>\n"
                + "<li><span style=\"font-size: small;\">&nbsp;<strong>Voc&ecirc; excedeu o limite de ativa&ccedil;&otilde;es</strong> - neste caso, entre em contato conosco para desbloquearmos o c&oacute;digo.&nbsp;</span></li>\n"
                + "<li><span style=\"font-size: small;\"><strong>&nbsp;C&oacute;digo inv&aacute;lido</strong> - neste caso voc&ecirc; est&aacute; inserindo algum caracter do c&oacute;digo errado. Sugerimos copiar e colar o c&oacute;digo na primeira caixa de texto na tela de ativa&ccedil;&atilde;o.</span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"font-size: small;\">Nunca abra reclama&ccedil;&atilde;o antes de entrar em contato conosco. Sempre resolvemos os problemas/d&uacute;vidas de nossos clientes</span></p>\n"
                + "<p><span style=\"font-size: small;\">Kaspersky Total Security &ndash; multidispositivos 2018 &eacute; a solu&ccedil;&atilde;o de seguran&ccedil;a f&aacute;cil de usar com uma licen&ccedil;a para diversas plataformas que protege praticamente qualquer tipo de PC, Mac, smartphone Android e tablet Android contra malwares, criminosos virtuais e amea&ccedil;as da Internet. Independentemente do tipo de dispositivo que voc&ecirc; usa, a Kaspersky pode proteg&ecirc;-los: e as informa&ccedil;&otilde;es sigilosas armazenadas neles.&nbsp;</span></p>\n"
                + "<p><span style=\"font-size: small;\">&nbsp;</span></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p style=\"text-align: left;\">&nbsp;&nbsp;<img src=\"http://ap.imagensbrasil.org/images/2017/09/03/Semtitulo.png\" alt=\"\" width=\"564\" height=\"174\" />&nbsp;</p>";
    }

    public String corpoKISHTML(int qtd, String codigo, Vendas v, String nome) {
        String nomeProduto = VariaveisDeControle.mapProd.get(v.getIdProduto()).getNomeProduto();
        return "<p>&nbsp;</p>\n"
                + "<table style=\"height: 324px; background-color: #f5f5f5; width: 920px; float: left;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">Caro(a) " + nome + " .</span></p>\n"
                + "<p><span style=\"font-size: small;\">Obrigado pela sua compra na loja online da KSafe.</span></p>\n"
                + "<p><span style=\"font-size: small;\">Esta mensagem &eacute; um resumo do seu pedido e sugerimos que a guarde como comprovante.&nbsp;</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">N&uacute;mero do Pedido: " + v.getId() + "</span></p>\n"
                + "<p><span style=\"font-size: small;\">Forma de Pagamento: " + v.getFormaPagamento() + "</span></p>\n"
                + "<table style=\"height: 19px; background-color: #006a5a; width: 855px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td><span style=\"color: #ffffff; font-size: small;\"><strong>Nome do Produto &nbsp; &nbsp; &nbsp;&nbsp;</strong></span></td>\n"
                + "<td><strong><span style=\"color: #ffffff; font-size: small;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Qtd Comprada</span></strong></td>\n"
                + "<td><strong><span style=\"font-size: small;\"><span style=\"color: #ffffff;\">Valor &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></span></strong></td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"//5
                + "<p><span style=\"font-size: small;\">" + nomeProduto + " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + v.getQtd() + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; " + v.getValor() + "</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: medium; color: #ff0000;\"><strong>C&oacute;digo de ativa&ccedil;&atilde;o: " + codigo + "</strong></span></p>\n"
                + "<p><br /><br /><span style=\"font-size: small;\"><span><strong>LEIA COM ATEN&Ccedil;&Atilde;O:</strong><br /><span>Este email cont&eacute;m seu c&oacute;digo de ativa&ccedil;&atilde;o. Salve-o ou imprima-o e o guarde em um lugar seguro.</span></span></span></p>\n"
                + "<p><span style=\"font-size: small;\"><span><span><strong><span style=\"text-decoration: underline;\">Se voc&ecirc; estiver usando a vers&atilde;o de avalia&ccedil;&atilde;o do produto que comprou</span></strong><br /><span>1. Clique com o bot&atilde;o direito do mouse no &iacute;cone \"\"K\"\" do Kaspersky no canto inferior direito da &aacute;rea de trabalho.</span><br /><span>2. Clique em \"Ativar\".</span><br /><span>3. Siga as instru&ccedil;&otilde;es para ativar o software.Instru&ccedil;&otilde;es Gerais de Instala&ccedil;&atilde;o</span><br /><span>Antes de iniciar a instala&ccedil;&atilde;o de seu novo software da Kaspersky Lab, remova todos os softwares antiv&iacute;rus e antispyware instalados no computador. Se tiver dificuldades ao desinstalar softwares de terceiros, h&aacute; ferramentas de remo&ccedil;&atilde;o dispon&iacute;veis&nbsp; aqui: http://support.kaspersky.com/us/consumer/tools-utilities</span>. Ao concluir esse procedimento, execute as etapas a seguir:</span></span></span></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><span><span><span><span>Caso voc&ecirc; ainda n&atilde;o tenha baixado a vers&atilde;o mais recente do Kaspersky Internet Security, fa&ccedil;a-o agora. <span><strong>Internet Security 2018 vers&atilde;o portugu&ecirc;s Windows</strong>: " + linkKIS + "<strong>" + mensagemDownload + " &nbsp;</strong></span></span></span></span></span></span></li>\n"
                + "<li><span style=\"font-size: small;\">Voc&ecirc; tamb&eacute;m pode baixar o arquivo de instala&ccedil;&atilde;o das vers&otilde;es MAC, iPhone e Android: <a href=\"https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial\">https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial</a></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Salve o arquivo no computador. </span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Siga as instru&ccedil;&otilde;es na tela e, quando solicitado, insira seu c&oacute;digo de ativa&ccedil;&atilde;o. &Eacute; necess&aacute;rio ter uma conex&atilde;o com a Internet durante a ativa&ccedil;&atilde;o.</span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Reinicie o computador para concluir a instala&ccedil;&atilde;o.&nbsp;</span></span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"text-decoration: underline;\"><strong><span style=\"font-size: small;\">Em alguns casos pode aparecer as seguintes mensagens:</span></strong></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><strong>Certificado de servidor n&atilde;o confi&aacute;vel</strong> - caso ocorra, reinicie o computador. Se persistir o probrema, desinstale o antivirus e instale novamente.</span></li>\n"
                + "<li><span style=\"font-size: small;\">&nbsp;<strong>Voc&ecirc; excedeu o limite de ativa&ccedil;&otilde;es</strong> - neste caso, entre em contato conosco para desbloquearmos o c&oacute;digo.&nbsp;</span></li>\n"
                + "<li><span style=\"font-size: small;\"><strong>&nbsp;C&oacute;digo inv&aacute;lido</strong> - neste caso voc&ecirc; est&aacute; inserindo algum caracter do c&oacute;digo errado. Sugerimos copiar e colar o c&oacute;digo na primeira caixa de texto na tela de ativa&ccedil;&atilde;o.</span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"font-size: small;\">Nunca abra reclama&ccedil;&atilde;o antes de entrar em contato conosco. Sempre resolvemos os problemas/d&uacute;vidas de nossos clientes</span></p>\n"
                + "<p><span style=\"font-size: small;\"><span>Kaspersky Internet Security &ndash; multidispositivos 2018 &eacute; a solu&ccedil;&atilde;o de seguran&ccedil;a f&aacute;cil de usar com uma licen&ccedil;a para diversas plataformas que protege praticamente qualquer tipo de PC, Mac, smartphone Android e tablet Android contra malwares, criminosos virtuais e amea&ccedil;as da Internet. Independentemente do tipo de dispositivo que voc&ecirc; usa, a Kaspersky pode proteg&ecirc;-los: e as informa&ccedil;&otilde;es sigilosas armazenadas neles.</span></span></p>\n"
                + "<p><span style=\"font-size: small;\">&nbsp;</span></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p style=\"text-align: left;\">&nbsp;&nbsp;<img src=\"http://ap.imagensbrasil.org/images/2017/09/03/Semtitulo.png\" alt=\"\" width=\"564\" height=\"174\" />&nbsp;</p>";
    }

    public String corpoAndroidHTML(int qtd, String codigo, Vendas v, String nome) {
        String nomeProduto = VariaveisDeControle.mapProd.get(v.getIdProduto()).getNomeProduto();
        return "<p style=\"color: #222222; font-family: arial, sans-serif; font-size: 12.8px;\">&nbsp;</p>\n"
                + "<table style=\"color: #222222; font-family: arial, sans-serif; font-size: 12.8px; height: 324px; background-color: #f5f5f5; width: 920px; float: left;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td style=\"font-family: arial, sans-serif; margin: 0px;\">\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">Caro(a) " + nome + ".</span></p>\n"
                + "<p><span style=\"font-size: small;\">Obrigado pela sua compra na loja online da KSafe.</span></p>\n"
                + "<p><span style=\"font-size: small;\">Esta mensagem &eacute; um resumo do seu pedido e sugerimos que a guarde como comprovante.&nbsp;</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">N&uacute;mero do Pedido: " + v.getId() + "</span></p>\n"
                + "<p><span style=\"font-size: small;\">Forma de Pagamento: " + v.getFormaPagamento() + "</span></p>\n"
                + "<table style=\"height: 19px; background-color: #006a5a; width: 855px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td style=\"font-family: arial, sans-serif; margin: 0px;\"><span style=\"color: #ffffff; font-size: small;\"><strong>Nome do Produto &nbsp; &nbsp; &nbsp;&nbsp;</strong></span></td>\n"
                + "<td style=\"font-family: arial, sans-serif; margin: 0px;\"><strong><span style=\"color: #ffffff; font-size: small;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Qtd Comprada</span></strong></td>\n"
                + "<td style=\"font-family: arial, sans-serif; margin: 0px;\"><strong><span style=\"font-size: small;\"><span style=\"color: #ffffff;\">Valor &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></span></strong></td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p><span style=\"font-size: small;\">" + nomeProduto + " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + v.getQtd() + " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; " + v.getValor() + "</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: medium; color: #ff0000;\"><strong>C&oacute;digo de ativa&ccedil;&atilde;o:&nbsp;" + codigo + "<br /></strong></span></p>\n"
                + "<p><br /><br /><span style=\"font-size: small;\"><strong>LEIA COM ATEN&Ccedil;&Atilde;O:</strong><br />Este email cont&eacute;m seu c&oacute;digo de ativa&ccedil;&atilde;o. Salve-o ou imprima-o e o guarde em um lugar seguro.</span></p>\n"
                + "<p><span style=\"font-size: small;\"><strong><span style=\"text-decoration-line: underline;\">Se voc&ecirc; estiver usando a vers&atilde;o de avalia&ccedil;&atilde;o do produto que comprou</span></strong>:</span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\">Caso voc&ecirc; ainda n&atilde;o tenha baixado a vers&atilde;o mais recente do Kaspersky Internet Security for Android, fa&ccedil;a-o agora. Para isso, baixe aqui:&nbsp;</span><a style=\"font-size: small;\" href=\"https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial\">https://www.kaspersky.com.br/downloads/thank-you/internet-security-free-trial</a>&nbsp;</li>\n"
                + "<li><span style=\"font-size: small;\">Execute no seu Smartphone</span></li>\n"
                + "<li><span style=\"font-size: small;\">Siga as instru&ccedil;&otilde;es na tela e, quando solicitado, insira seu c&oacute;digo de ativa&ccedil;&atilde;o. &Eacute; necess&aacute;rio ter uma conex&atilde;o com a Internet durante a ativa&ccedil;&atilde;o.</span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"text-decoration-line: underline;\"><strong><span style=\"font-size: small;\">Em alguns casos pode aparecer as seguintes mensagens:</span></strong></span></p>\n"
                + "<ol>\n"
                + "<li style=\"margin-left: 15px;\"><span style=\"font-size: small;\"><strong>Certificado de servidor n&atilde;o confi&aacute;vel</strong>&nbsp;- caso ocorra, reinicie o computador. Se persistir o probrema, desinstale o antivirus e instale novamente.</span></li>\n"
                + "<li style=\"margin-left: 15px;\"><span style=\"font-size: small;\">&nbsp;<strong>Voc&ecirc; excedeu o limite de ativa&ccedil;&otilde;es</strong>&nbsp;- neste caso, entre em contato conosco para desbloquearmos o c&oacute;digo.&nbsp;</span></li>\n"
                + "<li style=\"margin-left: 15px;\"><span style=\"font-size: small;\"><strong>&nbsp;C&oacute;digo inv&aacute;lido</strong>&nbsp;- neste caso voc&ecirc; est&aacute; inserindo algum caracter do c&oacute;digo errado. Sugerimos copiar e colar o c&oacute;digo na primeira caixa de texto na tela de ativa&ccedil;&atilde;o.</span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"font-size: small;\">Nunca abra reclama&ccedil;&atilde;o antes de entrar em contato conosco. Sempre resolvemos os problemas/d&uacute;vidas de nossos clientes</span></p>\n"
                + "<p><span style=\"font-size: small;\">&nbsp;</span></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p style=\"color: #222222; font-family: arial, sans-serif; font-size: 12.8px;\">&nbsp;&nbsp;<img class=\"CToWUd a6T\" style=\"cursor: pointer; outline: 0px;\" src=\"https://ci6.googleusercontent.com/proxy/5INTFWRawMXdinQRQji9U_bL1GbnhLMzUPyM0qFw2Ec6FevFBgfWE3ScnQ8TXPsxvtLnSlMI4sece_8VHzy2-hRP05IJnjIIVKrq3iLtKb50=s0-d-e1-ft#http://ap.imagensbrasil.org/images/2017/09/03/Semtitulo.png\" alt=\"\" width=\"564\" height=\"174\" /></p>\n"
                + "<p>&nbsp;</p>";
    }

    public String corpoSMALLHTML(int qtd, String codigo, Vendas v, String nome) {
        String nomeProduto = VariaveisDeControle.mapProd.get(v.getIdProduto()).getNomeProduto();
        return "<p>&nbsp;</p>\n"
                + "<table style=\"height: 324px; background-color: #f5f5f5; width: 920px; float: left;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">Caro(a) " + nome + " .</span></p>\n"
                + "<p><span style=\"font-size: small;\">Obrigado pela sua compra na loja online da KSafe.</span></p>\n"
                + "<p><span style=\"font-size: small;\">Esta mensagem &eacute; um resumo do seu pedido e sugerimos que a guarde como comprovante.&nbsp;</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">N&uacute;mero do Pedido: " + v.getId() + "</span></p>\n"
                + "<p><span style=\"font-size: small;\">Forma de Pagamento: " + v.getFormaPagamento() + "</span></p>\n"
                + "<table style=\"height: 19px; background-color: #006a5a; width: 855px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td><span style=\"color: #ffffff; font-size: small;\"><strong>Nome do Produto &nbsp; &nbsp; &nbsp;&nbsp;</strong></span></td>\n"
                + "<td><strong><span style=\"color: #ffffff; font-size: small;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Qtd Comprada</span></strong></td>\n"
                + "<td><strong><span style=\"font-size: small;\"><span style=\"color: #ffffff;\">Valor &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></span></strong></td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n" // 1
                + "<p><span style=\"font-size: small;\">" + nomeProduto + " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + v.getQtd() + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; " + v.getValor() + "</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: medium; color: #ff0000;\"><strong>C&oacute;digo de ativa&ccedil;&atilde;o: " + codigo + "</strong></span></p>\n"
                + "<p><br /><br /><span style=\"font-size: small;\"><span><strong>LEIA COM ATEN&Ccedil;&Atilde;O:</strong><br /><span>Este email cont&eacute;m seu c&oacute;digo de ativa&ccedil;&atilde;o. Salve-o ou imprima-o e o guarde em um lugar seguro.</span></span></span></p>\n"
                + "<p><span style=\"font-size: small;\"><span><span><strong><span style=\"text-decoration: underline;\">Se voc&ecirc; estiver usando a vers&atilde;o de avalia&ccedil;&atilde;o do produto que comprou</span></strong><br /><span>1. Clique com o bot&atilde;o direito do mouse no &iacute;cone \"\"K\"\" do Kaspersky no canto inferior direito da &aacute;rea de trabalho.</span><br /><span>2. Clique em \"Ativar\".</span><br /><span>3. Siga as instru&ccedil;&otilde;es para ativar o software.Instru&ccedil;&otilde;es Gerais de Instala&ccedil;&atilde;o</span><br /><span>Antes de iniciar a instala&ccedil;&atilde;o de seu novo software da Kaspersky Lab, remova todos os softwares antiv&iacute;rus e antispyware instalados no computador. Se tiver dificuldades ao desinstalar softwares de terceiros, h&aacute; ferramentas de remo&ccedil;&atilde;o dispon&iacute;veis&nbsp; aqui: http://support.kaspersky.com/us/consumer/tools-utilities</span><span>. Ao concluir esse procedimento, execute as etapas a seguir:</span></span></span></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><span><span><span><span>Caso voc&ecirc; ainda n&atilde;o tenha baixado a vers&atilde;o mais recente do Kaspersky Total Security, fa&ccedil;a-o agora. <span><strong>Small Office 5 Portugu&ecirc;s</strong>:&nbsp;<span>&nbsp;</span><a href=\"http://brazil.kaspersky.com/downloads/versoes-de-teste/small-office-security\" rel=\"noreferrer\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?hl=pt-BR&amp;q=http://brazil.kaspersky.com/downloads/versoes-de-teste/small-office-security&amp;source=gmail&amp;ust=1504491089646000&amp;usg=AFQjCNG7g3GcGbFVNigYbfTLlp0iod9g2A\">http://brazil.kaspersky.com/downloads/versoes-de-teste/<span class=\"il\">small</span>-office-security</a></span></span></span></span></span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Salve o arquivo no computador. </span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Siga as instru&ccedil;&otilde;es na tela e, quando solicitado, insira seu c&oacute;digo de ativa&ccedil;&atilde;o. &Eacute; necess&aacute;rio ter uma conex&atilde;o com a Internet durante a ativa&ccedil;&atilde;o.</span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Reinicie o computador para concluir a instala&ccedil;&atilde;o.&nbsp;</span></span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"text-decoration: underline;\"><strong><span style=\"font-size: small;\">Em alguns casos pode aparecer as seguintes mensagens:</span></strong></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><strong>Certificado de servidor n&atilde;o confi&aacute;vel</strong> - caso ocorra, reinicie o computador. Se persistir o probrema, desinstale o antivirus e instale novamente.</span></li>\n"
                + "<li><span style=\"font-size: small;\">&nbsp;<strong>Voc&ecirc; excedeu o limite de ativa&ccedil;&otilde;es</strong> - neste caso, entre em contato conosco para desbloquearmos o c&oacute;digo.&nbsp;</span></li>\n"
                + "<li><span style=\"font-size: small;\"><strong>&nbsp;C&oacute;digo inv&aacute;lido</strong> - neste caso voc&ecirc; est&aacute; inserindo algum caracter do c&oacute;digo errado. Sugerimos copiar e colar o c&oacute;digo na primeira caixa de texto na tela de ativa&ccedil;&atilde;o.</span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"font-size: small;\">Nunca abra reclama&ccedil;&atilde;o antes de entrar em contato conosco. Sempre resolvemos os problemas/d&uacute;vidas de nossos clientes</span></p>\n"
                + "<p><span style=\"font-size: small;\"><span>&nbsp;</span></span></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p style=\"text-align: left;\">&nbsp;&nbsp;<img src=\"http://ap.imagensbrasil.org/images/2017/09/03/Semtitulo.png\" alt=\"\" width=\"564\" height=\"174\" />&nbsp;</p>";
    }

    public String mensagemIncidenteAdicionado(String nome, String id) {

        String s = "Caro(a) " + nome + ", obrigado por contatar a K Safe.<br>"
                + "<br>"
                + "Seu pedido de suporte foi recebido pela equipe técnica de suporte.<br><br>"
                + "O número de seu protocolo é: " + id
                + "<br>Iremos solucioná-lo o mais rápido possível. Aguarde nosso retorno, em breve responderemos!"
                + "<br><br>Atenciosamente,"
                + "<br>Suporte Técnico KSafe";
        return s;
    }

    public String mensagemIncidenteEncerrado(String nome, int motivo, String codigo) {

        String s = "Caro(a) " + nome + ", seu incidente foi encerrado em nosso sistema.";
        if (motivo == 1 || motivo == 2) {
            s = s + "<br>Você já pode utilizar o seu código '" + codigo + "' novamente."
                    + "<br>Em caso de outros problemas, entre em contato novamente, estamos dispostos a atendê-lo!";
        } else if (motivo == 3) {
            s = s + "<br><br>Seu código foi substituído. Siga os seguintes passos abaixo:"
                    + "<br><br>Passo 1 - Eliminar as licenças:"
                    + "<br>Abra o Kaspersky"
                    + "<br>Clique na licença no canto inferior direito da janela."
                    + "<br>Clique no X no lado direito do número de licença/chave."
                    + "<br>Se você não vê um X na parte superior, clique na seta no centro da janela, depois, clique no \"X\" ou \"excluir codigo predefinido\"."
                    + "<br>Clique em Sim para excluir a licença."
                    + "<br>Se você ver um outro X, clique nele e clique em Sim para excluir a licença."
                    + "<br>Você será avisado o aplicativo não está ativado."
                    + "<br>Reinicie o seu PC"
                    + "<br>Passo 2 - Reativar:"
                    + "<br>Abra o Kaspersky"
                    + "<br>Clique em \"licença\" no canto inferior direito da janela."
                    + "<br>Clique em \"Ativar o aplicativo\" ou \"inserir o codigo de ativação\""
                    + "<br>Digite o código de ativação apenas no numero de dispositivos conforme a sua compra. Você receberá um novo email com seu(s) código(s) \n"
                    + "<br>Clique em Avançar e aguarde o processo para ser executado.\n"
                    + "<br>Clique em Concluir.\n"
                    + "<br>Clique em Fechar";
        } else if (motivo == 4) {
            s = s + "<br><br>Caso o problema ainda persista, entre em contato imediatamente conosco.";
        }
        s = s + "<br><br><br>Atenciosamente,"
                + "<br><br>Suporte Técnico KSafe";
        return s;
    }

    public String atualizacaoPrograma(String nome, String tipo) {
        String corpo = "Caro " + nome + ". Há poucos dias a Kaspersky lançou a nova versão 2018 do seu programa para usuários domésticos do Windows. Para baixar,"
                + " clique no link abaixo, ou copie e cole no navegador, e em seguida escolha a opção \"startup\".\n"
                + "Para instalar, não precisa desinstalar a versão atual do seu computador. Basta execultar o arquivo que o programa será atualizado";
        if (tipo.equals("TOTAL")) {
            corpo = corpo + "Link para download: " + "http://products.kaspersky-labs.com/portuguese/homeuser/kts2018/for_reg_pt/";
        } else if (tipo.equals("KIS")) {
            corpo = corpo + "Link para download: " + "http://products.kaspersky-labs.com/portuguese/homeuser/kis2018/for_reg_pt/";
        }
        corpo = corpo + "\n\n\nEm caso de dúvidas ou outras solicitações, entre em contato conosco. Estamos a sua disposição.\n"
                + "Suporte KSafe (antiga Furtado Antivirus)";
        return corpo;
    }

    private String corpoAntivirusHTML(int qtd, String codigo, Vendas v, String nome) {
        String nomeProduto = VariaveisDeControle.mapProd.get(v.getIdProduto()).getNomeProduto();
        return "<p>&nbsp;</p>\n"
                + "<table style=\"height: 324px; background-color: #f5f5f5; width: 920px; float: left;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">Caro(a) " + nome + " .</span></p>\n"
                + "<p><span style=\"font-size: small;\">Obrigado pela sua compra na loja online da KSafe.</span></p>\n"
                + "<p><span style=\"font-size: small;\">Esta mensagem &eacute; um resumo do seu pedido e sugerimos que a guarde como comprovante.&nbsp;</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small;\">N&uacute;mero do Pedido: " + v.getId() + "</span></p>\n"
                + "<p><span style=\"font-size: small;\">Forma de Pagamento:" + v.getFormaPagamento() + "</span></p>\n"
                + "<table style=\"height: 19px; background-color: #006a5a; width: 855px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td><span style=\"color: #ffffff; font-size: small;\"><strong>Nome do Produto &nbsp; &nbsp; &nbsp;&nbsp;</strong></span></td>\n"
                + "<td><strong><span style=\"color: #ffffff; font-size: small;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Qtd Comprada</span></strong></td>\n"
                + "<td><strong><span style=\"font-size: small;\"><span style=\"color: #ffffff;\">Valor &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></span></strong></td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"//4
                + "<p><span style=\"font-size: small;\">" + nomeProduto + " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + v.getQtd() + " &nbsp; " + v.getValor() + "</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: medium; color: #ff0000;\"><strong>C&oacute;digo de ativa&ccedil;&atilde;o: " + codigo + "</strong></span></p>\n"
                + "<p><br /><br /><span style=\"font-size: small;\"><span><strong>LEIA COM ATEN&Ccedil;&Atilde;O:</strong><br /><span>Este email cont&eacute;m seu c&oacute;digo de ativa&ccedil;&atilde;o. Salve-o ou imprima-o e o guarde em um lugar seguro.</span></span></span></p>\n"
                + "<p><span style=\"font-size: small;\"><span><span><strong><span style=\"text-decoration: underline;\">Se voc&ecirc; estiver usando a vers&atilde;o de avalia&ccedil;&atilde;o do produto que comprou</span></strong><br /><span>1. Clique com o bot&atilde;o direito do mouse no &iacute;cone \"\"K\"\" do Kaspersky no canto inferior direito da &aacute;rea de trabalho.</span><br /><span>2. Clique em \"Ativar\".</span><br /><span>3. Siga as instru&ccedil;&otilde;es para ativar o software.Instru&ccedil;&otilde;es Gerais de Instala&ccedil;&atilde;o</span><br /><span>Antes de iniciar a instala&ccedil;&atilde;o de seu novo software da Kaspersky Lab, remova todos os softwares antiv&iacute;rus e antispyware instalados no computador. Se tiver dificuldades ao desinstalar softwares de terceiros, h&aacute; ferramentas de remo&ccedil;&atilde;o dispon&iacute;veis&nbsp; aqui  http://support.kaspersky.com/us/consumer/tools-utilities <span>. Ao concluir esse procedimento, execute as etapas a seguir:</span></span></span></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><span><span><span><span>Caso voc&ecirc; ainda n&atilde;o tenha baixado a vers&atilde;o mais recente do Kaspersky Antivirus, fa&ccedil;a-o agora. <span><strong>Antivirus 2018 vers&atilde;o portugu&ecirc;s Windows</strong>: " + linkAntivirus + "<strong>.&nbsp;</strong></span></span></span></span></span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Salve o arquivo no computador. </span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Siga as instru&ccedil;&otilde;es na tela e, quando solicitado, insira seu c&oacute;digo de ativa&ccedil;&atilde;o. &Eacute; necess&aacute;rio ter uma conex&atilde;o com a Internet durante a ativa&ccedil;&atilde;o.</span></span></li>\n"
                + "<li><span style=\"font-size: small;\"><span>Reinicie o computador para concluir a instala&ccedil;&atilde;o.&nbsp;</span></span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"text-decoration: underline;\"><strong><span style=\"font-size: small;\">Em alguns casos pode aparecer as seguintes mensagens:</span></strong></span></p>\n"
                + "<ol>\n"
                + "<li><span style=\"font-size: small;\"><strong>Certificado de servidor n&atilde;o confi&aacute;vel</strong> - caso ocorra, reinicie o computador. Se persistir o probrema, desinstale o antivirus e instale novamente.</span></li>\n"
                + "<li><span style=\"font-size: small;\">&nbsp;<strong>Voc&ecirc; excedeu o limite de ativa&ccedil;&otilde;es</strong> - neste caso, entre em contato conosco para desbloquearmos o c&oacute;digo.&nbsp;</span></li>\n"
                + "<li><span style=\"font-size: small;\"><strong>&nbsp;C&oacute;digo inv&aacute;lido</strong> - neste caso voc&ecirc; est&aacute; inserindo algum caracter do c&oacute;digo errado. Sugerimos copiar e colar o c&oacute;digo na primeira caixa de texto na tela de ativa&ccedil;&atilde;o.</span></li>\n"
                + "</ol>\n"
                + "<p><span style=\"font-size: small;\">Nunca abra reclama&ccedil;&atilde;o antes de entrar em contato conosco. Sempre resolvemos os problemas/d&uacute;vidas de nossos clientes</span></p>\n"
                + "<p><span style=\"font-size: small;\"><span>&nbsp;</span></span></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p style=\"text-align: left;\">&nbsp;&nbsp;<img src=\"http://ap.imagensbrasil.org/images/2017/09/03/Semtitulo.png\" alt=\"\" width=\"564\" height=\"174\" />&nbsp;</p>";
    }

    public String atualizarEmail(String nome) {
        return "<p><img src=\"http://ap.imagensbrasil.org/images/2017/09/02/unnamed.png\" alt=\"\" width=\"150\" height=\"93\" />&nbsp;&nbsp;</p>\n"
                + "<table style=\"height: 233px; background-color: #f5f5f5; width: 673px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td>\n"
                + "<p><span style=\"font-size: small; color: #333333; font-family: arial, helvetica, sans-serif;\">Ol&aacute; " + nome + ", este &eacute; um email de confirma&ccedil;&atilde;o, n&atilde;o precisa responder.</span></p>\n"
                + "<p><span style=\"font-size: small; color: #333333; font-family: arial, helvetica, sans-serif;\">Seu email foi atualizado com sucesso em nosso sistema. Lembre-se de nos avisar caso voc&ecirc; mude de email, &eacute; atrav&eacute;s dele que entraremos em contato para informar sobre a sua renova&ccedil;&atilde;o. At&eacute; logo!</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small; color: #333333; font-family: arial, helvetica, sans-serif;\">Att</span></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><span style=\"font-size: small; color: #333333; font-family: arial, helvetica, sans-serif;\">Atendimento ao cliente KSafe</span></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>";
    }

    public String AvisarCodigoEnviado(String nome, String assunto) {
        return "Olá " + nome + ", esta é uma mensagem automática."
                + "<br>Seu código acaba de ser enviado em outra mensagem e com certeza já chegou no seu email. Estamos avisando por aqui, pois, devido o email conter links, é muito comum que vá para a caixa de spam/lixo eletrônico. O assunto da mensagem é este:"
                + "<br>"
                + "<br>" + assunto + "\"<br>"
                + "<br>"
                + "Procure seu código nessas caixas se não encontrar na caixa de entrada. Se mesmo assim não encontrar, entre em contato conosco. "
                + "<br>Até logo!"
                + "<br><br>Atendimento ao Cliente KSafe";
    }

    public String emailAvisoExpirando(String nome, String diasRestantes,Vendas v,String codigo) {
        String nomeProduto = VariaveisDeControle.mapProd.get(v.getIdProduto()).getNomeProduto();
        return "<table style=\"height: 457px; background-color: #eceeee; width: 815px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td>\n"
                + "<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img style=\"vertical-align: text-top;\" src=\"http://ap.imagensbrasil.org/images/2017/09/02/unnamed.png\" alt=\"\" width=\"150\" height=\"93\" /></p>\n"
                + "<p>&nbsp;</p>\n"
                + "<table class=\"m_-4147323065920542052devicewidthinner\" style=\"height: 256px; width: 600px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td style=\"font-family: Arial, Helvetica, sans-serif; margin: 0px; font-size: 24px; color: #007461; line-height: normal; padding: 20px 20px 5px; text-align: center;\" align=\"center\" bgcolor=\"#ffffff\" width=\"100%\">\n"
                + "<p><img class=\"CToWUd\" style=\"vertical-align: text-top;\" src=\"https://ci3.googleusercontent.com/proxy/grkOAx-37otKrhSQPypVih7Vv830NzF5dP4UDJuwPvso91NBQnuNik1MYRgo6PI2EBuKL9GshjjZLyD8GsNKGXagEZt0ieFBwc_EKCZr77w4yBFN6EvAcBbLWMKVzDrokUYAbj_uNSBxtBK02ZeKHendIiU=s0-d-e1-ft#http://drh.img.digitalriver.com/DRHM/Storefront/Site/kasperuk/pb/images/Notifications/tick.png\" alt=\"icon\" width=\"25\" height=\"25\" /><span class=\"m_-4147323065920542052toptitle\">&nbsp;&nbsp;LEMBRETE DE RENOVA&Ccedil;&Atilde;O DE ASSINATURA&nbsp;</span></p>\n"
                + "<p style=\"text-align: left;\"><strong style=\"color: #666666; text-align: start; font-size: 14px;\">Prezado(a) "+nome+",</strong><br style=\"color: #666666; font-size: 12px; text-align: start;\" /><br style=\"color: #666666; font-size: 12px; text-align: start;\" /><span style=\"color: #666666; font-size: 12px; text-align: start;\">Nossos registros mostram que a sua licen&ccedil;a Kaspersky est&aacute; pr&oacute;ximo do final da validade, "+diasRestantes+" dia(s) a partir de hoje.</span></p>\n"
                + "<table style=\"height: 108px; background-color: #eceeee; width: 537px;\" border=\"0\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td>\n"
                + "<p style=\"text-align: left;\"><span style=\"font-size: small; font-family: arial, helvetica, sans-serif;\"><strong>Como voc&ecirc; &eacute; um cliente importante para n&oacute;s, gostar&iacute;amos de lhe oferecer&nbsp;</strong></span><span style=\"font-size: small; font-family: arial, helvetica, sans-serif;\"><strong><span style=\"color: #ff0000;\">at&eacute; 20% de desconto</span> na sua renova&ccedil;&atilde;o.</strong></span></p>\n"
                + "<p><span style=\"font-size: small; font-family: arial, helvetica, sans-serif;\"><strong><span style=\"color: ##ff0000;\">Cinco</span> dias antes do vencimento da sua assinatura, n&oacute;s entraremos em contato novamente com os dados para pagamento da renova&ccedil;&atilde;o. Por isso, fique de olho no seu email. Se poss&iacute;vel, nos adicione como contato para evitar o n&atilde;o recebimento do email.</strong></span></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p style=\"text-align: left;\">&nbsp;</p>\n"
                + "<p style=\"text-align: left;\"><strong><span style=\"font-size: small; color: #000000;\">Detalhes da assinatura</span></strong></p>\n"
                + "<p style=\"text-align: left;\"><strong><span style=\"font-size: small; color: #000000;\">Nome do Produto: <span style=\"color: #3366ff;\">"+nomeProduto+"</span></span></strong><br /><strong><span style=\"font-size: small; color: #000000;\">N&uacute;mero do pedido original: <span style=\"color: #3366ff;\">"+v.getId()+"</span></span></strong><br /><strong><span style=\"font-size: small; color: #000000;\">Data do pedido: <span style=\"color: #3366ff;\">"+v.getData()+"</span></strong><br /><strong><span style=\"font-size: small; color: #000000;\">C&oacute;digo de Ativa&ccedil;&atilde;o: <span style=\"color: #3366ff;\">"+codigo+"</span></span></strong><br /><strong><span style=\"font-size: small; color: #000000;\"></span></strong></p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>\n"
                + "<p>&nbsp;</p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p>&nbsp;</p>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>";
    }
}
