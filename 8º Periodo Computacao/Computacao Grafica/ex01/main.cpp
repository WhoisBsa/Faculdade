#define GLUT_DISABLE_ATEXIT_HACK

// #include <windows.h>
#include <GL/glut.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float altura = 400, largura = 400;

// Inicializa opengl
void init(void)
{
  glClearColor(0.0, 0.0, 0.0, 0.0);
  glShadeModel(GL_SMOOTH);
}

// Eixos coordenados
void DesenhaEixos()
{
  glLineWidth(1.0);
  glBegin(GL_LINES);
  glColor3f(1.0, 0.0, 0.0);
  glVertex3f(-10.0, 0.0, 0.0);
  glVertex3f(10.0, 0.0, 0.0);
  glColor3f(0.0, 1.0, 0.0);
  glVertex3f(0.0, -10.0, 0.0);
  glVertex3f(0.0, 10.0, 0.0);
  glEnd();

  glLineWidth(1.0);
}

void DesenhaObjetos()
{

  glColor3f(1.0, 1.0, 0.0);
  glBegin(GL_POLYGON);
  glVertex3f(2.0, 2.0, 0.0);
  glVertex3f(8.0, 2.0, 0.0);
  glVertex3f(2.0, 8.0, 0.0);
  glEnd();

  glColor3f(0.60, 0.60, 0.60);
  glBegin(GL_LINES);
    glVertex3f(-2.0, -2.0, 0.0);
    glVertex3f(-8.0, -2.0, 0.0);
    glVertex3f(-8.0, -2.0, 0.0);
    glVertex3f(-2.0, -8.0, 0.0);
    glVertex3f(-2.0, -8.0, 0.0);
    glVertex3f(-8.0, -8.0, 0.0);
  glEnd();

  glColor3f(0.0, 1.0, 0.0);
  glBegin(GL_LINE_STRIP);
  glVertex3f(2.0, -2.0, 0.0);
  glVertex3f(8.0, -2.0, 0.0);
  glVertex3f(2.0, -8.0, 0.0);
  glVertex3f(2.0, -2.0, 0.0);
  glEnd();
}

void desenha(void)
{
  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

  // Define viewport do canto superior esquerdo
  glViewport((int)10, (int)200, (int)180, (int)180);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  glOrtho(-10.0, 10.0, -10.0, 10.0, -10.0, 10.0);
  //define e carrega a matriz ModelView
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  //desenha os eixos
  DesenhaEixos();
  //desenha os objetos
  DesenhaObjetos();

  // Define viewport do canto superior esquerdo
  glViewport((int)200, (int)200, (int)180, (int)180);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  glOrtho(-1.0, 10.0, -1.0, 10.0, -10.0, 10.0);
  //define e carrega a matriz ModelView
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  //desenha os eixos
  DesenhaEixos();
  //desenha os objetos
  DesenhaObjetos();

  // Define viewport do canto superior esquerdo
  glViewport((int)10, (int)10, (int)180, (int)180);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  glOrtho(-10.0, 1.0, -10.0, 1.0, -10.0, 10.0);
  //define e carrega a matriz ModelView
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  //desenha os eixos
  DesenhaEixos();
  //desenha os objetos
  DesenhaObjetos();

  // Define viewport do canto superior esquerdo
  glViewport((int)200, (int)10, (int)180, (int)180);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  glOrtho(-1.0, 10.0, -10.0, 1.0, -10.0, 10.0);
  //define e carrega a matriz ModelView
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  //desenha os eixos
  DesenhaEixos();
  //desenha os objetos
  DesenhaObjetos();

  glutSwapBuffers();
  glutPostRedisplay();
}

void keyboard(unsigned char key, int x, int y)
{
  switch (key)
  {
  case 27:
    exit(0);
    break;
  }
  glutPostRedisplay();
}

//Mouse callback

void mouse(int button, int state, int x, int y)
{
  //Inverte mouse para que a origem fique no canto inferior esquerdo da janela
  // por default, a origem é no canto superior esquerdo
  y = 400 - y;

  if (button == GLUT_LEFT_BUTTON)
  {
    if (state == GLUT_DOWN)
    {
      printf("x: %d\n", x);
      printf("y: %d\n\n", y);
    }
  }

  if (button == GLUT_RIGHT_BUTTON)
  {
    if (state == GLUT_DOWN)
    {
    }
  }
}

int main(int argc, char **argv)
{
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
  glutInitWindowSize((int)largura, (int)altura);
  glutInitWindowPosition(20, 20);
  glutCreateWindow("Viewport Test");
  init();
  glutDisplayFunc(desenha);
  glutKeyboardFunc(keyboard);
  glutMouseFunc(mouse);
  glutMainLoop();
  return 0;
}