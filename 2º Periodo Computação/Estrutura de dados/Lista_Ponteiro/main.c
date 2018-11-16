#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int chave;
    /* outros componentes*/
}tipoItem;

typedef struct celula_str *apontador;

typedef struct celula_str {
    tipoItem item;
    apontador prox;
}celula;

typedef struct {
    apontador primeiro, ultimo;
} tipoLista;

/*Função para criar LISTA vazia*/
void criaListaVazia (tipoLista *LISTA){
    LISTA->primeiro = (apontador) malloc(sizeof(celula));
    LISTA->ultimo = LISTA->primeiro;
    LISTA->primeiro->prox = NULL;
}

/*Função que retorna 1 se a LISTA estiver vazia*/
int vazia (tipoLista LISTA){
    return (LISTA.primeiro == LISTA.ultimo);
}

void insere (tipoItem x, tipoLista *LISTA){
    LISTA->ultimo->prox = (apontador) malloc(sizeof(celula));
    LISTA->ultimo = LISTA->ultimo->prox;
    LISTA->ultimo->item = x;
    LISTA->ultimo->prox = NULL;
}

void imprime (tipoLista LISTA){
    apontador aux;
    aux = LISTA.primeiro->prox;

    while (aux != NULL){
        printf("%d \n", aux->item.chave);
        aux = aux->prox;
    }
}


int consulta (tipoLista LISTA, int x){
    apontador aux;
    aux = LISTA.primeiro->prox;
    while (aux != NULL){
        if (aux->item.chave == x)
            return 1;
        aux = aux->prox;
    }
    return 0;
}

//consulta um determinado registro e retorna o anterior
apontador consultaR (tipoLista LISTA, int x){
    apontador aux, Anterior;
    Anterior = LISTA.primeiro;
    aux = LISTA.primeiro->prox;
    while (aux != NULL){
        if (aux->item.chave == x)
            return Anterior;
        Anterior = aux;
        aux = aux->prox;
    }
    return NULL;
}

void retira (apontador p, tipoLista *LISTA){
    /*o item a ser retirado é o seguinte apontado por p*/
    apontador q;
    if (vazia(*LISTA) || p==NULL || p->prox==NULL){
        printf("Erro: LISTA vazia ou posicao nao existe");
        return;
    }
    q = p->prox;
    p->prox = q->prox;

    if (p->prox == NULL)
        LISTA->ultimo = p;

    free(q);
}

int insereqlq(tipoItem c, tipoItem x, tipoLista *LISTA)
{

    apontador aux;


    aux = LISTA->primeiro->prox;

    while (aux != NULL){
        if(aux->item.chave == x.chave){
            apontador p = (apontador) malloc(sizeof(celula));
            p->prox = aux->prox;
            aux->prox = p;
            p->item = c;

           return 1;
        }
            aux = aux->prox;
    }

    return 0;
}

int main(int argc, char *argv[]){

    tipoLista minhaLista;
    tipoItem itemAux, itemN, itemA;
    apontador apontadorAux;
    int op, codigo;
    criaListaVazia(&minhaLista);

    do{
        system("cls");
        printf(" 1 - Inserir \n 2 - consultar \n 3 - Imprimir\n 4 - Excluir \n 5 - Inserir em qualquer lugar \n 6 - Trocar Ordem \n 0 - Zerar Lista\n-1 - Sair \n\n Sua opcao: ");
        scanf("%d", &op);

        switch (op){
            /*Opção de Inserir*/
            case 1:
                printf("\nChave: ");
                scanf("%d", &itemAux.chave);

                    if(consulta(minhaLista,itemAux.chave) == 0){
                        insere(itemAux,&minhaLista);
                    }else{
                    printf("Elemento Existente\n");
                    system("PAUSE");
                    }
            break;

            /*Opção de consultar*/
            case 2:
                printf("\nChave a ser consultada: ");
                scanf("%d", &codigo);
                if (consulta(minhaLista,codigo)==0)
                    printf("\nNao existe elemento com o codigo informado.\n");
                else
                    printf("\nCodigo encontrado.\n");
                system("Pause");
            break;

            /*Opção de imprimir*/
            case 3:
                if (vazia(minhaLista))
                    printf("\nLISTA vazia!");
                else{
                    printf("\nElementos da LISTA\n");
                    imprime(minhaLista);
                    system("Pause");
                }
            break;


            /*Opção de Excluir*/
            case 4:
                printf("\nChave a ser excluida: ");
                scanf("%d", &codigo);
                apontadorAux = consultaR(minhaLista,codigo);
                if (apontadorAux == NULL)
                    printf("\nNao existe elemento com o codigo informado.\n");
                else{
                    retira(apontadorAux, &minhaLista);
                    printf("\nCodigo encontrado.\n");
                }
                system("Pause");
            break;

            case 5:

                printf("digite a chave: ");
                scanf("%d", &itemA.chave);
                printf("digite o valor: ");
                scanf("%d", &itemN.chave);
                if(insereqlq(itemN,itemA,&minhaLista) == 1){
                    printf("Inserido\n");
                }else{
                    printf("Erro\n");
                }
                system("PAUSE");
            break;

            case 0:
                criaListaVazia(&minhaLista);
                printf("Lista Vazia\N");
                system("PAUSE");

            break;
        } //SWTICH
    }while (op != -1); //DO .. WHILE
    system("PAUSE");
    return 0;
} //FINALIZANDO O MAIN

