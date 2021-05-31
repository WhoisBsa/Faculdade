#define GLUT_DISABLE_ATEXIT_HACK

// #include <windows.h>
#include <GL/glut.h>
#include <GL/freeglut.h>
#include <stdlib.h>
#include <stdio.h>
#include <string>
#include <ctime>

void desenhaLabirinto();

bool vivo = true;
bool ganhou = false;
int ciclo = 0;
int bombasColetadas = 0;
int numeroBombas = 10;
char strBombasPlacar[10];

int r = 255, g = 255, b = 255, scalex = 0;
GLfloat win;
GLint view_w, view_h;
float pos_x = 0.0, pos_y = 0.0, scale_x = 1.0, scale_y = 1.0, angle = 0.0;
float windowSizeX = 600;
float windowSizeY = 600;
float subdivisoes = 17;
float passo = windowSizeX / subdivisoes;
int posicao_heroi_y = 0; //linha
int posicao_heroi_x = 0; //coluna

float pos_inicial_hb1_y = 282.352;
float pos_inicial_hb1_x = 141.176;
bool dir_hb1 = true;
int step_hb1 = 0;

float pos_inicial_hb2_y = 388.235;
float pos_inicial_hb2_x = 35.294;
bool dir_hb2 = true;
int step_hb2 = 0;

float pos_inicial_hb3_y = 211.764;
float pos_inicial_hb3_x = 211.764;
bool dir_hb3 = true;
int step_hb3 = 0;
char set_time[10] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
int left = 0;
int right = 9;

int matriz[17][17] = {
    {2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    {2, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2},
    {2, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2},
    {2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 2},
    {2, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 2},
    {2, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 2},
    {2, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
    {2, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 2},
    {2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2},
    {2, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 2},
    {2, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2},
    {2, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 2},
    {2, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 2},
    {2, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2},
    {2, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 2},
    {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2},
    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};

void posicionaBombas()
{
    int bombas = 0;
    int aleatorio;
    int posicao = 0;
    char pausa;
    bool status;

    while (bombas < numeroBombas)
    {
        posicao == 0;
        aleatorio = rand() % (289);
        status = true;

        // printf("Aleatório: %d", aleatorio);
        // printf("Posicao: %d", posicao);
        // scanf("%c", &pausa);

        // printf(" \n");
        for (int i = 0; i < subdivisoes && status; i++)
        {
            for (int j = 0; j < subdivisoes && status; j++)
            {
                if (posicao == aleatorio)
                {
                    posicao = 0;
                    if (matriz[i][j] == 0)
                    {
                        bombas++;
                        // printf("[%i][%i] == %i  \nbomba: %i", i, j, matriz[i][j], bombas);
                        matriz[i][j] = 3;
                        // scanf("%c", &pausa);
                    }
                    status = false;
                }
                posicao++;
            }
            // printf("\n");
        }
        status = false;
    }
}

void desenhaHomeBomba()
{
    glColor3ub(100, 100, 0);

    glPushMatrix(); // homem bomba 1
    glBegin(GL_QUADS);
    glVertex2i(pos_inicial_hb1_x, pos_inicial_hb1_y);
    glVertex2i(pos_inicial_hb1_x, pos_inicial_hb1_y + passo);
    glVertex2i(pos_inicial_hb1_x + passo, pos_inicial_hb1_y + passo);
    glVertex2i(pos_inicial_hb1_x + passo, pos_inicial_hb1_y);
    glEnd();
    glPopMatrix();

    glPushMatrix(); // homem bomba 2
    glColor3ub(100, 100, 0);
    glBegin(GL_QUADS);
    glVertex2i(pos_inicial_hb2_x, pos_inicial_hb2_y);
    glVertex2i(pos_inicial_hb2_x, pos_inicial_hb2_y + passo);
    glVertex2i(pos_inicial_hb2_x + passo, pos_inicial_hb2_y + passo);
    glVertex2i(pos_inicial_hb2_x + passo, pos_inicial_hb2_y);
    glEnd();
    glPopMatrix();

    glPushMatrix(); // homem bomba 3
    glColor3ub(100, 100, 0);
    glBegin(GL_QUADS);
    glVertex2i(pos_inicial_hb3_x, pos_inicial_hb3_y);
    glVertex2i(pos_inicial_hb3_x, pos_inicial_hb3_y + passo);
    glVertex2i(pos_inicial_hb3_x + passo, pos_inicial_hb3_y + passo);
    glVertex2i(pos_inicial_hb3_x + passo, pos_inicial_hb3_y);
    glEnd();
    glPopMatrix();

    // printf("ciclo: %d\n", ciclo);
    glutPostRedisplay();
}

void movimentoHomeBomba()
{
    // HOME BOMBA 1
    if (dir_hb1 && ciclo == 500 && step_hb1 != 5)
    {
        pos_inicial_hb1_x += passo;
        step_hb1++;
        if (step_hb1 == 5)
        {
            dir_hb1 = false;
        }
    }
    else if (!dir_hb1 && ciclo == 500 && step_hb1 != 0)
    {
        pos_inicial_hb1_x -= passo;
        step_hb1--;
        if (step_hb1 == 0)
        {
            dir_hb1 = true;
        }
    }

    // HOME BOMBA 2
    if (dir_hb2 && ciclo == 300 && step_hb2 != 4)
    {
        pos_inicial_hb2_x += passo;
        step_hb2++;
        if (step_hb2 == 4)
        {
            dir_hb2 = false;
        }
    }
    else if (!dir_hb2 && ciclo == 300 && step_hb2 != 0)
    {
        pos_inicial_hb2_x -= passo;
        step_hb2--;
        if (step_hb2 == 0)
        {
            dir_hb2 = true;
        }
    }

    // HOME BOMBA 3
    if (dir_hb3 && ciclo == 750 && step_hb3 != 9)
    {
        pos_inicial_hb3_x += passo;
        step_hb3++;
        if (step_hb3 == 9)
        {
            dir_hb3 = false;
        }
    }
    else if (!dir_hb3 && ciclo == 750 && step_hb3 != 0)
    {
        pos_inicial_hb3_x -= passo;
        step_hb3--;
        if (step_hb3 == 0)
        {
            dir_hb3 = true;
        }
    }

    switch (ciclo)
    {
    case 1000:
        ciclo = 0;
        break;
    default:
        ciclo++;
        break;
    }
}

void gameOver()
{
    glClear(GL_COLOR_BUFFER_BIT);

    glPushMatrix(); // game over
    glColor3ub(255, 0, 0);
    glBegin(GL_QUADS);
    glVertex2i(100, 100);
    glVertex2i(100, 500);
    glVertex2i(500, 500);
    glVertex2i(500, 100);
    glEnd();
    glPopMatrix();
    // glutPostRedisplay();

    glColor3ub(0, 255, 0);
    // GAME
    glRasterPos2i(200, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'G');
    glRasterPos2i(224, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'A');
    glRasterPos2i(248, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'M');
    glRasterPos2i(276, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'E');
    // OVER
    glRasterPos2i(300, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'O');
    glRasterPos2i(324, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'V');
    glRasterPos2i(348, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'E');
    glRasterPos2i(372, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'R');
}

void timeOut()
{
    glClear(GL_COLOR_BUFFER_BIT);

    glPushMatrix(); // TIME OUT
    glColor3ub(255, 0, 0);
    glBegin(GL_QUADS);
    glVertex2i(100, 100);
    glVertex2i(100, 500);
    glVertex2i(500, 500);
    glVertex2i(500, 100);
    glEnd();
    glPopMatrix();
    // glutPostRedisplay();

    glColor3ub(0, 255, 0);
    // TIME
    glRasterPos2i(200, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'T');
    glRasterPos2i(224, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'I');
    glRasterPos2i(248, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'M');
    glRasterPos2i(276, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'E');
    // OUT
    glRasterPos2i(300, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'O');
    glRasterPos2i(324, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'U');
    glRasterPos2i(348, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'T');

}

void youWin()
{
    glClear(GL_COLOR_BUFFER_BIT);

    glPushMatrix(); // game over
    glColor3ub(0, 255, 255);
    glBegin(GL_QUADS);
    glVertex2i(100, 100);
    glVertex2i(100, 500);
    glVertex2i(500, 500);
    glVertex2i(500, 100);
    glEnd();
    glPopMatrix();

    glColor3ub(255, 0, 0);
    // YOU
    glRasterPos2i(200, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'Y');
    glRasterPos2i(224, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'O');
    glRasterPos2i(248, 350);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'U');

    // WIM
    glRasterPos2i(300, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'W');
    glRasterPos2i(324, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'I');
    glRasterPos2i(338, 250);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'N');
}

int estaVivo()
{
    int hb1_x = int(pos_inicial_hb1_x);
    int hb1_y = int(pos_inicial_hb1_y);
    int hb2_x = int(pos_inicial_hb2_x);
    int hb2_y = int(pos_inicial_hb2_y);
    int hb3_x = int(pos_inicial_hb3_x);
    int hb3_y = int(pos_inicial_hb3_y);
    int heroi_x = int(pos_x);
    int heroi_y = int(pos_y);

    if (hb1_x == heroi_x && hb1_y == heroi_y)
    {
        return 0;
    }

    if (hb2_x == heroi_x && hb2_y == heroi_y)
    {
        return 0;
    }

    if (hb3_x == heroi_x && hb3_y == heroi_y)
    {
        return 0;
    }

    return true;
}

int venceu()
{
    if (bombasColetadas == numeroBombas)
    {
        return true;
    }
    return false;
}

void desenhaHeroi()
{
    glPushMatrix();
    glColor3ub(0, 0, 255);
    glTranslatef(pos_x, pos_y, 0.0);

    glBegin(GL_QUADS); // HERÓI
    glVertex2i(0, passo);
    glVertex2i(passo, passo);
    glVertex2i(passo, 0);
    glVertex2i(0, 0);
    glEnd();
    glPopMatrix();
}

void placar()
{
    int num;
    int tamanhoStr = sprintf(strBombasPlacar,"%d", (numeroBombas-bombasColetadas));

    // BOMBS:
    glColor3ub(0, 255, 0);
    glRasterPos2i(30, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'B');
    glRasterPos2i(54, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'O');
    glRasterPos2i(78, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'M');
    glRasterPos2i(102, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'B');
    glRasterPos2i(126, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'S');
    glRasterPos2i(150, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, ':');
    
    glColor3ub(255, 0, 0);
    int casa = 180;
    for (int i = 0; i < tamanhoStr; i++)
    {
        glRasterPos2i(casa, 570);
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, strBombasPlacar[i]);
        casa+=24;
    }
}

void temporizador(int value) {

    printf("Valor esquerdo: %d\nValor direito: %d\n\n", left, right);

    if (right == 0) {
        left--;
        right = 9;
    }

    right--;

    glutPostRedisplay();
    glutTimerFunc(1000,temporizador, 1);
}

void desenhaTimer() {

    // TIMER:
    glColor3ub(0, 255, 0);
    glRasterPos2i(300, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'T');
    glRasterPos2i(324, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'I');
    glRasterPos2i(340, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'M');
    glRasterPos2i(372, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'E');
    glRasterPos2i(396, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, 'R');
    glRasterPos2i(420, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, ':');
    
    glColor3ub(255, 0, 0);
    glRasterPos2i(444, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, '0');
    glRasterPos2i(468, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, '0');
    glRasterPos2i(492, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, ':');
    glRasterPos2i(516, 570);


    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, set_time[left]);
    glRasterPos2i(540, 570);
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, set_time[right]);
}

// Função callback para desenho
void desenha(void)
{
    // Inicializa o sistema de coordenadas
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    //Define os limites dos eixos x e y
    //Argumentos da função: void gluOrtho2D(GLdouble left, GLdouble right, GLdouble bottom, GLdouble top)
    gluOrtho2D(0.0f, windowSizeX, 0.0f, windowSizeY);

    //Limpa todos os pixels com a cor de fundo
    glClear(GL_COLOR_BUFFER_BIT);

    desenhaLabirinto();
    desenhaHomeBomba();

    // VERIFICA SE O HERÓI MORREU E FINALIZA O JOGO
    if (!vivo || ganhou)
    {
        // CONTA TEMPO PARA FECHAR
        time_t start, end;
        time(&start);
        do
            time(&end);
        while (difftime(end, start) <= 5.5);
        // FUNÇÃO PARA FECHAR
        glutLeaveMainLoop();
    }

    placar();
    desenhaTimer();

    vivo = estaVivo();
    ganhou = venceu();

    movimentoHomeBomba();

    // LOG DE POSIÇÃO

    // printf("x:%i | y:%f | HB3:%i | bomb: %i \n", int(pos_x), pos_y, int(pos_inicial_hb3_x), bombasColetadas);
    desenhaHeroi();

    if (!vivo)
    {
        gameOver();
    }
    if (left == 0 && right == 0) 
    {
        vivo = false;
        timeOut();
    }
    if (ganhou)
    {
        youWin();
    }

    // glutPostRedisplay();

    //Habilita a execução de comandos OpenGL
    glFlush();
}

void desenhaLabirinto(void)
{
    float passo_x, passo_y = 0;

    for (int y = 0; y < subdivisoes; y++) // linha y
    {
        passo_x = 0;
        for (int x = 0; x < subdivisoes; x++) // coluna x
        {
            switch (matriz[y][x])
            {
            case 1:
                glColor3ub(0, 220, 0);
                glBegin(GL_QUADS); // BLOCO
                glVertex2i(passo_x, passo_y);
                glVertex2i(passo_x, passo_y + passo);
                glVertex2i(passo_x + passo, passo_y + passo);
                glVertex2i(passo_x + passo, passo_y);
                glEnd();
                break;
            case 2:
                glColor3ub(90, 90, 90);
                glBegin(GL_QUADS); // MURO
                glVertex2i(passo_x, passo_y);
                glVertex2i(passo_x, passo_y + passo);
                glVertex2i(passo_x + passo, passo_y + passo);
                glVertex2i(passo_x + passo, passo_y);
                glEnd();
                break;
            case 3:
                glColor3ub(250, 90, 90);
                glBegin(GL_QUADS); // BOMBA
                glVertex2i(passo_x, passo_y);
                glVertex2i(passo_x, passo_y + passo);
                glVertex2i(passo_x + passo, passo_y + passo);
                glVertex2i(passo_x + passo, passo_y);
                glEnd();
                break;
            default:
                break;
            }
            passo_x += passo;
        }
        passo_y += passo;
    }
}

int autorizaMovimento(float x, float y, int direcao)
{
    //direção:
    //1 - para cima / 2 - para baixo
    //3 - direita / 4 - esquerda

    switch (direcao)
    {
    case 1: // CIMA
        if (posicao_heroi_y + 1 > 15)
        {
            printf("cima [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
            return false;
        }
        else
        {

            // 0 - caminho
            // 1 - labirinto
            // 2 - borda
            // 3 - bomba

            switch (matriz[posicao_heroi_y + 1][posicao_heroi_x])
            {
            case 0:
                printf("cima [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                posicao_heroi_y++;
                return true;
                break;
            case 1:
                return false;
                break;
            case 2:
                return false;
                break;
            case 3:
                printf("cima [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                matriz[posicao_heroi_y + 1][posicao_heroi_x] = 0;
                bombasColetadas++;
                posicao_heroi_y++;
                return true;
                break;
            default:
                break;
            }
        }

        break;
    case 2: // BAIXO
        if (posicao_heroi_y - 1 < 1)
        {
            printf("baixo [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
            return false;
        }
        else
        {
            switch (matriz[posicao_heroi_y - 1][posicao_heroi_x])
            {
            case 0:
                printf("baixo [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                posicao_heroi_y--;
                return true;
                break;
            case 1:
                return false;
                break;
            case 2:
                return false;
                break;
            case 3:
                printf("baixo [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                matriz[posicao_heroi_y - 1][posicao_heroi_x] = 0;
                bombasColetadas++;
                posicao_heroi_y--;
                return true;
                break;
            default:
                break;
            }
        }

        break;
    case 3: // DIREITA
        if (posicao_heroi_x + 1 > 15)
        {
            printf("direita [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
            return false;
        }
        else
        {
            switch (matriz[posicao_heroi_y][posicao_heroi_x + 1])
            {
            case 0:
                printf("direita [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                posicao_heroi_x++;
                return true;
                break;
            case 1:
                return false;
                break;
            case 2:
                return false;
                break;
            case 3:
                printf("direita [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                matriz[posicao_heroi_y][posicao_heroi_x + 1] = 0;
                bombasColetadas++;
                posicao_heroi_x++;
                return true;
                break;
            default:
                break;
            }
        }

        break;
    case 4:
        if (posicao_heroi_x - 1 < 1)
        {
            printf("esquerda [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
            return false;
        }
        else
        {
            switch (matriz[posicao_heroi_y][posicao_heroi_x - 1])
            {
            case 0:
                printf("esquerda [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                posicao_heroi_x--;
                return true;
                break;
            case 1:
                return false;
                break;
            case 2:
                return false;
                break;
            case 3:
                printf("esquerda [%d][%d]\n", posicao_heroi_y, posicao_heroi_x);
                matriz[posicao_heroi_y][posicao_heroi_x - 1] = 0;
                bombasColetadas++;
                posicao_heroi_x--;
                return true;
                break;
            default:
                break;
            }
        }

        break;
    }
    return true;
}

// Função callback chamada quando o tamanho da janela é alterado
void AlteraTamanhoJanela(GLsizei w, GLsizei h)
{
    // Especifica as dimensões da Viewport
    glViewport(0, 0, w, h);
    view_w = w;
    view_h = h;

    // Inicializa o sistema de coordenadas
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(-win, win, -win, win);
}

// Keyboard callback
void keyboard(unsigned char key, int x, int y)
{
    switch (key)
    {
    case 27:
        exit(0);
        break;

    case 'R':
        if (r != 255)
        {
            r += 1;
        }
        break;

    case 'r':
        if (r != 0)
        {
            r -= 1;
        }
        break;

    case 'G':
        if (g != 255)
        {
            g += 1;
        }
        break;

    case 'g':
        if (g != 0)
        {
            g -= 1;
        }
        break;

    case 'B':
        if (b != 255)
        {
            b += 1;
        }
        break;

    case 'b':
        if (b != 0)
        {
            b -= 1;
        }
        break;
    case 'A':
        angle += 1.0;
        break;
    case 'a':
        angle -= 1.0;
        break;
    case '+':
        scale_x += 1.0;
        scale_y += 1.0;
        break;
    case '-':
        scale_x -= 1.0;
        scale_y -= 1.0;
        break;
    }
    printf("Cores: RGB (%d,%d,%d)\n", r, g, b);
    glutPostRedisplay();
}

void specialKeys(int key, int x, int y)
{
    switch (key)
    {
    case GLUT_KEY_UP:
        //seta para cima
        if (autorizaMovimento(pos_x, pos_y, 1) == true)
        {
            pos_y += passo;
        }
        break;
    case GLUT_KEY_DOWN:
        //seta para baixo
        if (autorizaMovimento(pos_x, pos_y, 2) == true)
        {
            pos_y -= passo;
        }
        break;
    case GLUT_KEY_RIGHT:
        //seta para direita
        if (autorizaMovimento(pos_x, pos_y, 3) == true)
        {
            pos_x += passo;
        }
        break;
    case GLUT_KEY_LEFT:
        //seta para esquerda
        if (autorizaMovimento(pos_x, pos_y, 4) == true)
        {
            pos_x -= passo;
        }
        break;
    }
    glutPostRedisplay();
}

// Função callback chamada para gerenciar eventos do mouse
void GerenciaMouse(int button, int state, int x, int y)
{
    //Inverte mouse para que a origem fique no canto inferior esquerdo da janela
    // por default, a origem é no canto superior esquerdo
    y = windowSizeY - y;

    if (button == GLUT_LEFT_BUTTON)
    {
        if (state == GLUT_DOWN)
        {
            //ações com o botão direito pressionado
            printf("x: %d\ny: %d\n\n", x, y);
        }
    }
    glutPostRedisplay();
}

//Inicializa parâmetros
void init(void)
{
    // Configura a cor de fundo como preta
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    win = 250.0f;
}

//Principal
int main(int argc, char *argv[])
{
    srand((unsigned)time(0)); //para gerar números aleatórios reais.
    posicionaBombas();
    glutInit(&argc, argv);
    //Tipo de janela (single-buffered) e cores utilizados
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    //Configura o tamanho da janela
    glutInitWindowSize(windowSizeX, windowSizeY);
    //Configura a posição inicial da janela
    glutInitWindowPosition(100, 100);
    //Configura a janela
    glutCreateWindow("Mouse e Teclado no OpenGL");
    //configura o teclado
    glutKeyboardFunc(keyboard);
    //teclas especiais
    glutSpecialFunc(specialKeys);
    //mouse
    glutMouseFunc(GerenciaMouse);
    //Chama a função desenha
    glutDisplayFunc(desenha);
    //
    glutReshapeFunc(AlteraTamanhoJanela);
    glutTimerFunc(1000, temporizador, 1);
    //Inicializa o programa
    init();
    //Habilita o loop (máquina de estados)
    glutMainLoop();
}