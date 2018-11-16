#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

typedef struct{
    int cod;
    char nome[60];
    int vit;
    int derr;
    int emp;
} TipoFuncionario;

void GravaDados(FILE *arquivo, TipoFuncionario funcionario);
void LerArquivo(FILE *arquivo);
void alterarDados(FILE *arquivo, TipoFuncionario funcionario);


int main(int argc, char *argv[]){

    setlocale(LC_ALL, "portuguese");
    FILE *arquivo;
    TipoFuncionario funcionario; //auxiliar do TipoFuncionario que armazena os dados lidos
    int op;

    //tenta abrir o arquivo e caso não exista ele será criado
    arquivo=fopen("arquivofunconario.bin", "a+b");
    //fecha o arquivo
    fclose(arquivo);
    //abre o arquivo no modo r+b para ler e escrever em qualquer parte do arquivo, já que o a+b só escreve no final
    //não pode utilizar o r+b diretamente, pois ele não cria o arquivo caso ele não exista.
    arquivo=fopen("arquivofunconario.bin", "r+b");

    //testando se o arquivo foi aberto ou criado corretamente
    if(arquivo == NULL){
        printf("Ocorreu um erro ao abrir o arquivo!");
        return 1;
    }

    do{
        system("cls");
        printf("Opções:\n");
        printf("1 - Inserir Time\n");
        printf("2 - Alterar dado do Time\n");
        printf("3 - Remover Time\n");
        printf("4 - Lista de Times\n");
        printf("-1 - Sair\n");
        printf("Digite a sua opção: ");
        scanf("%d", &op);
        fflush(stdin);

        switch (op){

        case 1:
            //solicita os dados do funcionário
            printf("Digite o codigo do time: ");
            scanf("%d", &funcionario.cod);
            //esvazia o buffer de leitura
            fflush(stdin);
            TipoFuncionario f;
            fread(&f, sizeof(TipoFuncionario), 1, arquivo);
            if(f.cod == funcionario.cod){
                printf("Time ja cadastrado");
                getch();
            }else{
            printf("Digite o nome do time: ");
            gets(funcionario.nome);

            printf("Vitorias: ");
            scanf("%d", &funcionario.vit);

            printf("Derrotas: ");
            scanf("%d", &funcionario.derr);;

            printf("Empates: ");
            scanf("%d", &funcionario.emp);

            printf("Pontos: %d", funcionario.vit*3+funcionario.emp);

            GravaDados(arquivo, funcionario);}
            break;

        case 2:

            //solicita os dados do funcionário
            printf("Digite o codigo do time: ");
            scanf("%d", &funcionario.cod);
            //esvazia o buffer de leitura
            fflush(stdin);

            if(buscaFuncionario(arquivo, funcionario.cod)==1){
                printf("Digite o novo nome do funcionario: ");
                gets(funcionario.nome);
                alterarDados(arquivo, funcionario);
                printf("Dados alterados com sucesso");
                getch();
            }else{
                printf("Funcionario não encontrado");
            }
            break;


        case 4:
            //faz a leitura dos dados
            LerArquivo(arquivo);
            break;
        }

    }while(op!=-1);

    fclose(arquivo);
    getch();
    return 0;
}

void GravaDados(FILE *arquivo, TipoFuncionario funcionario){

    //posiciona o ponteiro no fim do arquivo
    fseek(arquivo, 0, SEEK_END);

    //grava os dados do funcionário
    fwrite(&funcionario, sizeof(TipoFuncionario), 1, arquivo);

    printf("\nDados gravados no arquivo! \n\nPressione ENTER para voltar ao menu anterior\n");
    getch();
}

void LerArquivo(FILE *arquivo){

    //posiciona o ponteiro no início do arquivo para iniciar a leitura dos dados
    fseek(arquivo, 0, SEEK_SET);

    TipoFuncionario funcionario;

    //enquanto não for final do arquivo
    while(!feof(arquivo)){
        //lê do arquivo e armazena na variável funcionario
        fread(&funcionario, sizeof(TipoFuncionario),1, arquivo);
        if (!feof(arquivo)){ //se não for final do arquivo imprime
            printf("Codigo do time: %d  \n", funcionario.cod);
            printf("Nome do time: %s\n", funcionario.nome);
            printf("Vitorias: %d  \n", funcionario.vit);
            printf("Derrotas: %d  \n", funcionario.derr);
            printf("Empates: %d  \n", funcionario.emp);
            printf("\n\n");
        }
    }
    getch();

}

void alterarDados(FILE *arquivo, TipoFuncionario funcionario){

    int cont=0;

    //posiciona o ponteiro no início do arquivo para iniciar a leitura dos dados
    fseek(arquivo, cont, SEEK_SET);

    TipoFuncionario f;

    //enquanto não for final do arquivo
    while(!feof(arquivo)){
        //lê do arquivo e armazena na variável funcionario
        fread(&f, sizeof(TipoFuncionario), 1, arquivo);
        if (!feof(arquivo)){ //se não for final do arquivo imprime
            if(f.cod == funcionario.cod){
                //posiciona o ponteiro na posição do registro atual
                fseek(arquivo, cont * sizeof(TipoFuncionario), SEEK_SET);
                //grava os dados do funcionário
                fwrite(&funcionario, sizeof(TipoFuncionario), 1, arquivo);
                return;
            }
        }
        cont++;
    }
}

int buscaFuncionario(FILE *arquivo, int cod){

    //posiciona o ponteiro no início do arquivo para iniciar a leitura dos dados
    fseek(arquivo, 0, SEEK_SET);

    TipoFuncionario f;

    //enquanto não for final do arquivo
    while(!feof(arquivo)){
        //lê do arquivo e armazena na variável funcionario
        fread(&f, sizeof(TipoFuncionario), 1, arquivo);
        if (!feof(arquivo)){ //se não for final do arquivo imprime
            if(f.cod == cod){
                return 1;
            }
        }
    }
    return 0;
}
