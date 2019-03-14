Redes de Computadores
=====================

# Introdução

### **Redes de computadores:**  

    Computadores que realizam diferentes tarefas separadas, porém, interconectadas.
    Conjunto de computadores autônomos interconectados por uma única tecnologia.

> Internet - Rede mundial de computadores  
> internet - Conjunto de redes qualquer

# Uso das redes:

 ***Aplicações comerciais***  
* ***Compartilhamento de recursos***  
* ***Cliente servidor***

**Comunicação**
> Email  
> Trabalho colaborativo  
> Vídeo conferência

**Lojas Online**  
> Vendas online  
> E-commerces

**Aplicações Domésticas**  
> Portal de notícias

**Comunicação Entre Pessoas**
> Aplicativos de mensagens  
> Salas de bate-papo  
> Redes sociais

**Entreterimento**
> Jogos online  
> Youtube  
> Streamming

**Compra Online**  
> Lojas virtuais

### **Redes Peer to Peer**
    1. Não existem clientes e servidores fixos.  
    2. Usuários compartilham dados entre si.  
        Ex: torrent.  
    3. Podem ter um banco de dados central ou não.

### **Redes sem fio x Redes móveis**

Sem Fio   |  Móvel  |  Exemplo
:-------: |:-------:| :-------
NÃO       | NÃO   | Rede Local Cabeada
NÃO       | SIM   | Rede de hotel com cabo
SIM       | NÃO   | Rede local com roteador wifi
SIM       | SIM   | 3G, 4G, etc. 


**Hardware de Rede**
> Dispositivos  
> Computadores  
> Roteadores  

**Classificação das Redes**
1. Dimensão  
2. Topologia  
3. Tecnologia de Transmissão  
4. Meio Físico

**DIMENSÃO**  
* LAN (Redes Locais)  
    >     Maximo de 1km a 2km  
    >     Em qualquer casa, tem-se um único meio físico compartilhado por todas as máquinas.

* MAN (Redes Metropolitanas)  
    >     Redes maiores que as LAN's.

* WAN (Redes geograficamente distribuídas)
    >     Abrangem áreas de tamanho de um país ou continente.
    >     Geralmente tem 2 partes (host e sub-rede de comunicação).

---
Distãncia entre os Processadores | Processadores no(a) mesmo(a) | Exemplo
|:----: | :----: | :----:|
1m     | m²     | Rede Pessoal
10m    | Casa   | Rede Local
100m   | Prédio | Rede Local
1km    | Campus | Rede Local
10km   | Cidade | MAN
100km  | País   | WAN
1000km | Continente | WAN
10000km| Planeta    | Internet  
---

**TOPOLOGIA**  
**Como a Rede é estruturada**  
TOPOLOGIA FÍSICA | TOPOLOGIA LÓGICA
--- | ---
Como o hardware da rede é estruturado | Como os dados transmitem de fato na rede

**Barramento:**
    
    Se faz necessário um mecanismo para controlar o acesso ao meio

**Estrela:**

    Toda a informação deve passar obrigatoriamente por uma estação central inteligente, que deve conectar cada estação da rede e distribuir o tráfego para que uma estação não receba, indevidamente, dados destinados às outras

**Anel:**

    Os bits se propagam individualmente pelo anel

**TOPOLOGIA DE TRANSMISSÃO**  
**Redes de difusão**

    Um único canal compartilhado por todas as máquinas.
    
    Todas as máquinas recebem a menssagem de um transmissor.

    Apenas a máquina de destino processa a menssagem.

**Broadcast**

    A mensagem é enviada para todas as máquinas e todas processam.

**Multicast**

    A mensagem é enviada para grupo de máquinas.

**Redes de difusão estática**

    O tempo é dividido para todas as máquinas.

    Bits extras para representar os grupos.

**Redes de difusão dinâmica**

    O meio físico é alocado sob demanda.
    
Com controle centralizado:

    Tem-se um controlador de acesso que comanda qual máquina deve transmitir

Com controle descentralizado:

    Não existe um controlador central de acesso.
    As próprias máquinas trocam informações de quem deve transmitir.

**Redes de Ponto a Ponto**

Comutação de pacotes

    Os pacotes podem chegar fora de ordem


# Software de Rede

**Antigamente**
 > HARDWARE

 **Hoje**
 > SOFTWARE

    A maioria das redes de computadores é organizada como um conjunto de camadas

**PROTOCOLOS**

    Conjunto de regras/convenssões entre os transmissores e receptores. É um acordo entre as partes

    Cada camada deve execuar uma função específica.

    
| | |  |
:---:|:---:|:---:
|Camada 5| <----> |Camada 5|
|Camada 4| <----> |Camada 4|
|Camada 3| <----> |Camada 3| 
|Camada 2| <----> |Camada 2|
|Camada 1| <----> |Camada 1|
|      |Usuário Físico|    |


    A camada N de uma máquina NÃO se comunica diretamente com a camada N de outra máquina.

    As camadas superiores enviam os dados para as camadas inferiores e o processo inverso é feito quando chega no destino.

**INTERFACES**

    Diz aos serviços o que a camada inferior tem a oferecer à camada superior, mas não especifica como isso será feito.

    Quando se tem um conjunto de camadas e protocolos definidos, tem-se uma arquitetura de rede.

    * Identificar transmissores e receptores
    * Controle de perdas
    * Controle de erros e aviso
    * Controle de sequência
    * Entre outras preocupações

**SERVIÇOS**

    Conjunto de operações referentes ao que a camada inferior oferece para a superior.

    O serviço está ligado à interface. O serviço não especifica como as operações devem ser feitas.

    O protocolo define o formato e o significado das mensagens.

    O protocolo e os serviços são independentes um do outro.  
    
    O protocolo pode ser alterado desde que não altere o serviço.

|Orientada a Conexão| X | Não Orientada a Conexão |
---| --- |---

**Orientada a Conexão**

    O usuário estabelece uma conexão, usa a conexão e finaliza a conexão.

    Há uma troca de mensagem entre as partes antes da transmissão.

    Geralmente a ordem é mantida.

**Não Orientada a Conexão**

    O transmissor insere o endereço do receptor no pacote e injeta na rede sem aviso prévio

**Serviços Confiáveis**

    Nunca perdem os dados (+ retorno).

# Modelos de Referência

    Responsável por padronizar e representar a comunicação em camadas.

    O modelo não especifica como as camadas devem executar suas funções.

**Modelo x Arquitetura**

    O modelo não precisa especificar os protocolos.

    A arquitetura define os protocolos a serem utilizados. É um conjunto/pilha de protocolos.

**Modelo OSI/ISO**

    OSI -> Open Systems Interconnection.
    
    Não é uma arquitetura.

    Trata da interconexão entre sistemas que estão abertos à comunicação. Independente de hardware ou software.

    Não especifica como as camadas devem executar suas funções.

    Estabelece uma série de regras ou orientações para que a comunicação ocorra.

    Cada camada é responsável por parte da comunicação.

    
**Princípios p/ criação do modelo OSI**

1. Uma nova camada deve ser criada sempre que ouver necessidade de um novo grau de abstração.
   
2. Cada camada deve executar uma função bem definida.
   
3. As funções das camadas devem ser escolhidas baseadas na definição de protocolos padronizados internacionalmente.

4. O limite entre as camadas deve ser definido visando minimizar o fluxo de informações entre as interfaces.

5. O número de camadas deve ser grande o suficiente para que funções completamente distintas não estejam na mesma camada e deve ser pequeno o suficiente para que a  arquitetura não se torne difícil de controlar.

    |Camada   |Nome   |
    |---|---:|
    |7  |Aplicação
    |6  |Apresentação
    |5  |Sessão
    |4  |Transporte
    |3  |Rede
    |2  |Enlace
    |1  |Física

**Aplicação**

    Alto nível, ligação com os usuários.
    
    Protocolos que rodam no cliente e no servidor.

    Protocolos sáo das próprias aplicações

    Ex: - HTTP
        - DNS
        - SMTP
  
**Apresentação**

    É uma camada de tradução.

    Ligada à sintaxe e semãntica.

    A função é converter a mensagem quando o padrão de caracteres entre as partes é diferente, de modo que ambas possam se entender.

    Compressão (transferência mais rápida) e Criptografia (mais segurança)

    Ex: - SSH
        - WPA2-PSK

**Sessão**

    Responsável por estabelecer sessões entre os usuários.

    Comunicação entre os processos das máquinas. 

    Controle de diálogo.

    Controle de início, fim e reinício da comunicação.

**Transporte**

    Responsável por receber os dados da camada de cima, dividir se necessário, enviar para a camada de rede e remontar o pacote no destino.

    Garante que os dados chegaram corretamente.

    Responsável pela sequência dos pacotes.

    Faz controle de fluxo da origem até o destino.

    Correção de erros que possam ter ocorrido em camadas inferiores.

    Estabelece uma conexão FIM-A-FIM entre transmissor e receptor.

**Rede**

    Responsável pelo endereçamento e rotas que o pacote deve tomar da origem até o destino.

    Faz o controle de congestionamento.

**Enlace**

    A função dessa camada é transformar um canal bruto de transmissão em uma linha que pareça livre de erros para a camada de rede.

    Faz o controle de fluxo nas duas maquinas conectadas.

**Física**

    É onde a comunicação real acontece.

    Transferencia de bits brutos por um canal de comunicação.

    Garantir que se sair 1 vai chegar 1.
    
    Ex: Frequência
        2200Hz -> 1
        1200Hz -> 0
