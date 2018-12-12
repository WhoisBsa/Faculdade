#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
#include <locale.h>

#define MaxTam 1000

typedef struct{
    int codigo;
    int nome[30];
    int endereco[30];
    int telefone[15];
}tipoItem;

typedef struct{
    tipoItem itens[MaxTam];
    int inicio, fim;
}tipoLista;

void criaListaVazia(tipoLista *lista)
{
    lista->inicio=0;
    lista->fim=0;
}

int vazia (tipoLista lista)
{
    if(lista.inicio==lista.fim){
        return 1;
    }
    return 0;
}

void insere(tipoItem x, tipoLista *lista)
{
    if(lista->fim>MaxTam){
        printf("lista cheia!");
    }else{
        lista->itens[lista->fim]=x;
        lista->fim++;
    }
}

void imprimeLista(tipoLista lista)
{
    int aux;
    for(aux=lista.inicio; aux<=lista.fim-1; aux++){
        printf("Codigo: %d\n", lista.itens[aux].codigo);
        printf("Nome: %s\n", lista.itens[aux].nome);
        printf("Endereco: %s\n",lista.itens[aux].endereco);
        printf("Telefone: %s",lista.itens[aux].telefone);
        printf("\n--------------------\n");
    }
    printf("\n");
}

int retira (int pos, tipoLista *lista)
{
    int aux;

    if (vazia(*lista) || pos>=lista->fim){
        return 0;
    }

    for (aux=pos; aux<lista->fim; aux++){
        lista->itens[aux]=lista->itens[aux+1];
    }

    lista->fim--;
    return 1;
}

int verifica(int cod, tipoLista lista)
{
    int aux;

    for(aux=lista.inicio; aux<=lista.fim; aux++){
        if(lista.itens[aux].codigo==cod){
            return 1;
        }
    }
    return 0;
}

int trocaPosicao(int cod1, int cod2, tipoLista *lista)
{
    int aux, pos1=0, pos2=0;

    for(aux=lista->inicio; aux<=lista->fim; aux++){
        if(lista->itens[aux].codigo==cod1){
            pos1=aux;
        }
        if(lista->itens[aux].codigo==cod2){
            pos2=aux;
        }
    }
    if(pos1==0 &&pos2==0){
        return 0;
    }else{
        tipoItem auxItem;
        auxItem=lista->itens[pos1];
        lista->itens[pos1]=lista->itens[pos2];
        lista->itens[pos2]=auxItem;
    }
    return 1;
}

int trocaItem(int cod, tipoLista *lista)
{
    int aux;

    for(aux=lista->inicio; aux<=lista->fim-1; aux++){
        if(lista->itens[aux].codigo==cod){
            printf("Informe o novo Código: ");
            scanf("%d",&lista->itens[aux].codigo);
            getchar();
            printf("Informe o novo Nome: ");
            gets(&lista->itens[aux].nome);
            printf("Informe o novo Endereco: ");
            gets(&lista->itens[aux].endereco);
            printf("Informe o novo Telefone: ");
            gets(&lista->itens[aux].telefone);
            return 1;
        }
    }
    return 0;
}

int imprimeCod(int cod, tipoLista lista)
{
    int aux;

    for(aux=lista.inicio; aux<=lista.fim-1; aux++){
        if(lista.itens[aux].codigo==cod){
            printf("Codigo: %d\n", lista.itens[aux].codigo);
            printf("Nome: %s\n", lista.itens[aux].nome);
            printf("Endereco: %s\n",lista.itens[aux].endereco);
            printf("Telefone: %s",lista.itens[aux].telefone);
            printf("\n--------------------\n");
            return 1;
        }
    }
    return 0;
}

int main()
{
    tipoItem aux;
    tipoLista agenda;
    int op, cod;

    criaListaVazia(&agenda);

    do{
        system("cls");
        printf("Informe uma opcao:\n");
        printf("1 - Cadastrar\n");
        printf("2 - Imprimir\n");
        printf("3 - Excluir\n");
        printf("4 - Pesquisa\n");
        printf("5 - Troca Posicao\n");
        printf("6 - Troca Item\n");
        printf("7 - Imprime expecifico\n");
        printf("8 - Zera Lista\n");
        printf("0 - Sair\n");
        scanf("%d",&op);

        if(op==1){
            printf("Codigo: ");
            scanf("%d",&aux.codigo);
            getchar();
            printf("Nome: ");
            gets(&aux.nome);
            printf("Endereco: ");
            gets(&aux.endereco);
            printf("Telefone: ");
            gets(&aux.telefone);

            insere(aux, &agenda);
            printf("\nElemento inserido\n");
        }

        if(op==2){
            printf("Lista impressa\n");
            imprimeLista(agenda);
        }

        if(op==3){
            printf("digite a posiçao: ");
            scanf("%d", &cod);
            if(retira(cod,&agenda)==1){
                printf("Excluido");
            }else{
                printf("Erro, posiçao inexistente");
            }
        }

        if(op==4){
            printf("Digite o codigo: ");
            scanf("%d", &cod);
            if(verifica(cod,agenda)==1){
                printf("Codigo existente\n");

            }else{
                printf("nao presente na lista");
            }
        }

        if(op==5){
            printf("Valores a serem trocados\n");
            int cod1, cod2;
            printf("V1: ");
            scanf("%d", &cod1);
            printf("V2: ");
            scanf("%d", &cod2);

            if(trocaPosicao(cod1,cod2,&agenda)==1){
                printf("\nTroca realizada\n");
            }else{
                printf("\nValor inexistente\n");
            }
        }

        if (op==6){
            printf("Informe o código do item a ser alterado:");
            scanf("%d", &cod);
            if (trocaItem(cod,&agenda)==1){
                printf("Item alterado com sucesso\n\n");
            }else{
                printf("Item não encontrado\n\n");
            }
        }

        if (op==7){
            printf("Informe o código a ser mostrado: ");
            scanf("%d", &cod);
            if (imprimeCod(cod,agenda)==1){
                printf("\n");
            }else{
                printf("Cod não encontrado\n\n");
            }
        }

        if(op==8){
            criaListaVazia(&agenda);
            printf("Lista Vazia");
        }

        system("PAUSE");
    }while(op>0);
    return 0;
}
