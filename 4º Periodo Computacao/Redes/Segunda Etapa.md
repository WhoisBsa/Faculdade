Redes de Computadores
=====================

# *DNS (DOMAIN NAME SYSTEM)*

Problema:

 1. Endereços de rede são dificeis de memorizar.
 2. Se o servidor for alterado, os endereços também serão alterados.  
 
    Foram introduzidos os nomes em ASCII, porém, é preciso algum mecanismo para converter esses nomes em endereços de rede.

Possível Solução:

- Um arquivo `.txt` compartilhado com todos os nomes DNS e seus endereços de IP.

Problemas:

* Se o txt ficar indisponível, a internet inteira sofreria.
* O arquivo ficaria muito grande.
* Sujeito a nomes duplicados.
  
  O DNS funciona com base em uma hierarquia e um sistema de banco de dados para implementar essa hierarquia.

**Domínios**

    A internet possui muitos domínios de nível superior.
    
    Cada domínio pode ter vários sub domínios e seguem uma hierarquia.
    Ex: maps.google.com

**Registros de Recursos**

    O DNS deve retornar um pacote com várias informações além do IP de destino.

    São os registros de recurso.

    A tarefa do DNS é receber um nome de domínio e responder um registro de recurso.
    Ex: nome do domínio; tempo de vida (TTL); classe; tipo; valor.


---
    Servidor DNS\ Servidor Local\ Servidor com Autoridade\ T.L.D\ ./

    Servidor raiz não resolve domínios mas sabe quem resolve.

**World Wide Web**

    Estrutura arquitetônica que permite acesso a diversos arquivos espalhadas por milhões de máquinas na Internet.

    Possui uma interface de fácil utilização.

    Diversos assuntos.

    W3C é a organização responsável pelo desenvolvimento da Web, Pela padronização de protocolos da Internet e pelo incentivo á interoperabilidade entre os sites.

    Do ponto de vista do usuário 
        Conjunto de arquivos
        Precisa de um software
        Navegador requisita e interpreta as páginas para mostrar ao usuário com todas as formatações.

    Precisa de uma linguagem que estabelece um padrão (HTML)

    O navegador é um interpretador de HTML.

**Hiperlinks e URL's**

Ex: `https://www.abcd.com/index.html`

3 partes:

    1. Nome do protocolo utilizado (HTTPS)
    2. Nome DNS da máquina onde está a página.
    3. Geralmente o arquivo ou o caminho do arquivo que contém a página.

**O lado do Cliente**

Ex: `http://www.youtube.com`

    1. Navegador determina a URL.
    2. Navegador requisita ao DNS o IP de www.youtube.com
    3. O DNS responde 208.65.153.238
    4. 0 cliente estabelece uma conexão TCP com máquina 208.65.153.238
    5. O navegador requisita a página incial de youtube.com
    6. O servidor envia o arquivo ao cliente.
    7. O cliente encerra a conexão.
    8. O navegador interpreta e mostra todo o teto ao usuário.
    9. O navegador busca e mostra as imagens.

**O lado do Servidor**

    1. O servidor aceita uma conexão TCP.
    2. O servidor verifica qual arquivo foi requisitado pelo cliente.
    3. O servidor busca o arquivo requisitado.
    4. O servidor envia o arquivo ao cliente.
    5. O servidor irá encerrar a conexão.

*Servidores modernos executam tarefas como autenticação, controle de acesso, log de servidor, etc.*

# *HTTP* - Hiper Text Transfer Protocol

    Protocolo de transferência de hipertexto.

    Define as mensagens que o cliente pode enviar ao servidor e as respostas que o cliente pode receber.

    Conexão TCP na porta 80 do servidor (modo habitual).

    TCP já faz um série de serviços, ex: Controle de fluxo, controle de perda de pacotes, mensagens duplicadas, mensagens com erros, entre outros.

    A vantagem pe que nem o cliente, nem o servidor precisam se preocupar com esses serviços.

## *HTTP 1.0*

* Estabelece conexão
* Faz 1 requisição
* Recebe 1 resposta
* Encerra a conexão
  
## *HTTP 1.1*

* Estabelece conexão
* Faz requisição
* Recebe resposta
* Requisições adicionais
* Resposta adicionais
* Encerra conexão
* Solicitações por pipeline
  
## Metadados HTTP

    Operações que o protocolo HTTP permite que sejam feitas.

*GET* → A maioria das requisições HTTP são via método GET. Serve para requisitar e obter algum arquivo no servidor.  
Ex:   
Método `Arquivo` `Vesão do Procolo`  
GET `index.html` `HTTP/1.1`

*HEAD* → Requisita pelo cabeçalho da página.

*PUT* → Oposto ao GET. Envia arquivos para o servidor. Possibilita ter um conjunto de páginas de maneira remota.

*POST* → Semelhante ao PUT. Mas não sobrescreve o arquivo anterior, só muda o que foi alterado de um para o outro. (Controle de Versão)

*DELETE* → Remover um arquivo

*TRACE* → Monitorar as solicitações com relação a problemas no envio. Pede ao servidor que reenvie a solicitação de volta.

*OPTIONS* → Serve para consultar informações do servidor.

## RESPOSTAS HTTP

    Linhas de status e informções adicionais
        ↓
    Toda a requisição HTTP recebe uma resposta.

Linhas de status indicam:  
* Solicitação recebida
* Em caso de problema, indicam a razão.

    
Código de  3 dígitos
1º dígito indica 1 entre 5 grupos de status.

Código  | Significado
---     | ---
1xxx    | Informação
2xxx    | Sucesso
3xxx    | Redirecionamento
4xxx    | Erro do cliente
5xx     | Erro do servidor

Ex: 
 
    200 → Sucesso total  
    301 → Page moved  
    404 → Page not found 

# *Camada de Transporte*

    Fornece comunicação entre processos de máquinas difentes.
    Camada de Rede - Comunicação entre os hosts.

*Remetente*

    Mensagens divididas em segmentos

*Destino*

    Remontar os seguimentos

## *2 protocolos*

*Cálculo de Bits*
{  
     2<sup>n</sup><sub>valores</sub> → n bits => 0 ---- 2<sup>n</sup> - 1  
}

**TCP**

    Entrega confiável (sem erros, sem perdas)
    Controle de fluxo
    Garante a entrega
    Controle de congestionamento
    Orientado à conexão

**UDP**

    Não confiável (não trata erros e perdas)
    Sem controle de fluxo
    Os seguimentos podem chegar fora de ordem.
    Sem conexão

*Vantagens*

    É mais rápido. (Não realiza os serviços do TCP)
    O cabeçalho do segmento é reduzido.
    Usado para streaming.
    É possível ter transporte confiável com UDP, mas isso deve ser implemenntado na camada de aplicação.
    A confiabilidade vai depender das aplicações.

*Segmento UDP*


||||
|---|:---:|---|
||32 bits||
|#porta de origem| |#porta de destino|
||Outros campos de cabeçalho||
||Dados da aplicação||
___

*UDP Checksum*

    Verificar possíveis erros 
    Divide os 32 bits em 2 segmentos de 16 bits
    Somar os 2 segmentos de 16 bits
    Fazer complemento de 1 da soma
    Se a soma de 17 bits, deve-se somar o bit a mais ao resultado antes de fazer o complemento.

    O checksum é o valor final obtido (complemento de 1)

    O transmissor insere o checksum no segmento UDP.

    O receptor recalcula o checksum e compara o valor obtido com o valor armazenado no segmento.
    Se os valores forem diferentes, significa que ocorreu algum erro.
    Se os valores forem iguais significa que não foram detectados erros.

## Protocolos com Paralelismo (Pipeline)

    Permitem o envio de vários segmentos sem confirmação.
    O intervalo dos números de sequência deve ser maior do que apenas 0 e 1.
    Os segmentos e ACKs podem chegar fora de ordem.
    O recebimento é bit a bit e o receptor envia o ACK ao receber o último bit do segmento.

**TCP**

    Protocolo de transfência confiável de dados
    Garante a entrega
    Garante a ordem
    Garante a integridade dos dados

    Permite paralelismo
    Faz controle de congestionamento
    Faz controle de fluxo

**Controle de congestionamento**

    Evita que o transmissor sobrecarregue a rede

**Controle de fluxo**

    Evita que o transmissor sobrecarregue o recptor

**Protocolo ponto a ponto**

    Estabelece conexão entre transmissor e receptor

**Orientado à conexão**

    Ocorre uma troca de mensagens de controle entre transmissor e receptor

**A comunicação é bidirecional na mesma conexão**

    O TCP com números de sequência e ACKs.
    nº de sequência: O nº do 1º byte do segmento
    nº de ACK: O nº do próximo byte que se espera do outro lado

**O ACK é cumulativo**

    A ordem de remontagem dos pacotes fica a critério do implementador, o TCP não define.

**Temporização**

    Esperar um tempo antes de retransmitir um segmento não confirmado.

    A divisão do tempo de espera é o mais importante.

    Tempo muito curto → Se os pacotes estiverem atrasados, vai ocorrer muita duplicação e isso gera sobrecarga.

    Tempo muito longo → A rede se torna lenta para agir em problemas de perda de pacotes.

    Pode-se estimar o tempo baseado no envio de um pacote

    Pode-se enviar vários pacotes e estimar a média de tempo de envio

    Deve existir armazenamento no transmissor e no receptor

O TCP gera transferência confiável em cima do serviço não confiável do IP.

Permite ACKs cumulativos e retransmissões.

As retransmissões ocorrem quando um tempo limite de espera da confirmação é esgotado.

**Controle de Fluxo**

    Rede → Transporte → Aplicação

    Os processos da aplicação podem ser muito lentos para ler os dados da camada de transporte.

    Possível solução?
    Estimar o tempo que a aplicação leva para ler um segmento.

    Força a camada de rede a enviar segmentos com o tempo acima do que foi estimado.

**Soluçao do TCP**

    O servidor mostra ao cliente quanto de espaço disponível existe no buffer de recepção para aquela conexão.

    Buffer de recepção → RcvWindow (Espaço disponível)
    Espaço total → RcvBuffer

    O servidor envia o valor do RcvWindow.

**Gerenciamento de conexão**

    É sempre o cliente que inicia a conexão.
    O servidor espera pedidos de conexão.

**Início da conexão TCP**
    
    1. O cliente envia um TCPSYN ao servidor com seu número de sequência inicial.
    2. O servidor recebe o SYN e responde com um SYNACK. O servidor processa o SYN, aloca os buffers e inicializa seu número de sequência.
    3. O cliente recebe o SYNACK.
   
**Fim da conexão TCP**

    1. O cliente envia um TCPFIN ao servidor.
    2. O servidor recebe o FIN, retorna um ACK, encerra a coneção e envia um FIN ao cliente.
    3. O cliente recebe o FIN e retorna o ACK.
    4. O servidor recebe o ACK, conexão finalizada.
   
# Camada de Rede

## Protocolo IP

- IPV4 → 32 bits 2^32 endereços
- IPV6 → 128 bits 2^128 endereços
  
**IPV4**

    32 bits (4 bytes)(4 octetos)
    Cada octeto → 8 bits
    Formato: 
        x   .    x   .    x   .    x
    1ºocteto 2ºocteto 3ºocteto 4ºocteto

    Ex:
        203.45.59.25
        23.2.1.128
        10.32.45.70

    Em binário:
        00000000.00000000.00000000.00000000
                         ↓
        11111111.11111111.11111111.11111111

    Em decimal:
        0   .  0  .  0  .  0
                  ↓
        255 . 255 . 255 . 255


|CLASSES |IP|
--|--
Classe A| 0.0.0.0 até 127.255.255.255
Classe B| 128.0.0.0 até 191.255.255.255
Classe C| 192.0.0.0 até 123.255.255.255
Classe D| 124.0.0.0 até 239.255.255.255
Classe E| 240.0.0.0 até 255.255.255.255

IP válido: único no mundo. Roteável.
IP privado: redes privadas.

Classe A

    10.0.0.0 → 10.255.255.255

Classe B

    172.16.0.0 → 172.31.25.255

Classe C

    192.168.0.0 → 192.168.255.255

Ex: Uma rede 192.168.0.0 → 192.168.0.255  
1º endereço = endereço da rede  
Último enderço = broadcast  
192.168.0.255 → 254 hosts (IPs válidos nessa rede), $2^8 -2$  
Alguns casos: Gateway

Ex: 10.0.0.0 → 10.255.255.255  
Hosts → 2^24-2  
Rede → 10.0.0.0
Broadcast → 10.255.255.255

