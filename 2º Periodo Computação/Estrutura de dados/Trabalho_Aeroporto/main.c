#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Node{
	int chave;
	int prioridade;
	struct Node *prox;
};

typedef struct Node node;

int tam;


void inicia(node *FILA)
{
	FILA->prox = NULL;
	tam=0;
}

int vazia(node *FILA)
{
	if(FILA->prox == NULL)
		return 1;
	else
		return 0;
}

int emergencia(int em)
{
    int aux=0;
    aux = em%3;
    aux += aux+(em%5);
    if(aux==7)
        return 1;
    else
        return 0;
}

int idImpar(){
    int n, impar;

    n = rand()%1000+1;
    if(n%2!=0){
    impar = n;
    }
    return impar;
}

int idPar(){
    int n, par;

    n = rand()%1000+1;
    if(n%2==0){
    par = n;
    }
    return par;
}

node *alocaPar()
{
    node *novo = (node *) malloc(sizeof(node));

	if(!novo){
		printf("Sem memoria disponivel!\n");
		exit(1);
	}else{
		novo->chave = idPar();
		return novo;
	}

}
node *alocaImpar()
{
    node *novo = (node *) malloc(sizeof(node));

	if(!novo){
		printf("Sem memoria disponivel!\n");
		exit(1);
	}else{
		novo->chave = idImpar();
		return novo;
	}

}

void inserePar(node *FILA)
{
	node *novo = alocaPar();

	novo->prox = NULL;

	if(vazia(FILA))
		FILA->prox=novo;
	else{
		node *tmp = FILA->prox;

        while(tmp->prox != NULL){
            tmp = tmp->prox;
        }

        tmp->prox = novo;
	}
}

void insereImpar(node *FILA)
{
	node *novo = alocaImpar();

	novo->prox = NULL;

	if(vazia(FILA))
		FILA->prox=novo;
	else{
		node *tmp = FILA->prox;
        while(tmp->prox != NULL){
            tmp = tmp->prox;
        }

        tmp->prox = novo;
    }
}



node *retira(node *FILA)
{
	if(FILA->prox == NULL){
		printf("Fila ja esta vazia\n");
		return NULL;
	}else{
		node *tmp = FILA->prox;
		FILA->prox = tmp->prox;
		tam--;
		return tmp;
	}
}


void imprimeA(node *FILA)
{
	if(vazia(FILA)){
		printf("Fila vazia!\n\n");
		return ;
	}

	node *tmp;
	tmp = FILA->prox;

	while(tmp != NULL){
        if(emergencia(tmp->chave)){
		printf("[*%d] ", tmp->chave);
        }else{
            printf("[%d] ", tmp->chave);
        }
        tmp = tmp->prox;
	}

	printf("\n\n");
}

void imprimeD(node *FILA)
{
	if(vazia(FILA)){
		printf("Fila vazia!\n\n");
		return ;
	}

	node *tmp;
	tmp = FILA->prox;

	while(tmp != NULL){
		printf("[%d] ", tmp->chave);
		tmp = tmp->prox;
	}

	printf("\n\n");
}

void libera(node *FILA)
{
	if(!vazia(FILA)){

		node *proxNode, *atual;

		atual = FILA->prox;

		while(atual != NULL){
			proxNode = atual->prox;
			free(atual);
			atual = proxNode;
		}
	}
}


int main(void)
{
    int op, i, j, contA=0, contD=0, contE=0, nRetira=0;
    node *aterrissagem = (node *) malloc(sizeof(node));
    node *decolagem = (node *)malloc(sizeof(node));
    node *tmp;
    int pista[3];

    srand(time(NULL));

    if(!decolagem || !aterrissagem){
		printf("Sem memoria disponivel!\n");
		exit(1);
	}
	else{
        inicia(aterrissagem);
        inicia(decolagem);
	}
    do{
        system("cls");

        j = rand()%5;

        for(i=0; i<j; i++){
            insereImpar(aterrissagem);
            contA++;
        }
        printf("Fila de Aterrissagem: ");
        imprimeA(aterrissagem);

        j = rand()%5;

        for(i=0; i<j; i++){
            inserePar(decolagem);
            contD++;
        }
        printf("\nFila de Decolagem: ");
        imprimeD(decolagem);

        if(vazia(decolagem)==0 && vazia(aterrissagem)==0){
            while(nRetira < 2){
               tmp = retira(aterrissagem);
               if(tmp != NULL){
                        printf("Pista %d: %d (aterrissando)\n\n", nRetira+1, tmp->chave);
                }
                free(tmp);
               // getch();
                nRetira++;
            }
            while(nRetira!=0){
                tmp = retira(decolagem);
                if(tmp != NULL){
                        printf("Pista %d: %d (decolando)\n\n", nRetira+1, tmp->chave);
                }
                free(tmp);
              //  getch();
                nRetira=0;
            }

        }


            else if(vazia(decolagem)==0 && vazia(aterrissagem)){
                tmp = retira(decolagem);
                while(nRetira<2){
                if(tmp != NULL){
                        printf("Pista %d: %d (decolando)\n\n", nRetira+1, tmp->chave);
                }
                free(tmp);
               // getch();
                nRetira++;
                }
            }


             else if(vazia(decolagem) && vazia(aterrissagem)==0){
                tmp = retira(aterrissagem);
                while(nRetira<2){
                    if(tmp != NULL){
                    printf("Pista %d: %d (aterrissando)\n\n", nRetira+1, tmp->chave);
                }
            }

            free(tmp);
            //getch();
            nRetira++;
            }

        printf("\nAvioes Aterrissados: %d", contA);
        printf("\nAvioes Decolados: %d", contD);
        printf("\nEmergencias: %d", contE);
        getch();
    }while(op);

    return 0;
}
