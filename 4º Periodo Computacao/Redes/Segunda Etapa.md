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
