#define GLUT_DISABLE_ATEXIT_HACK

// #include<windows.h>
#include <GL/glut.h>
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

float rotationX = 25.0, rotationY = 0.0;
int last_x, last_y;
int width = 640, height = 480;
float eixo_x = 1.0, eixo_y = 1.0, eixo_z = 1.0;
float a= 45.10, b= -8.80, c = -81.20;

int distOrigem = 45;

void init(void)
{
   glClearColor(1.0, 1.0, 1.0, 0.0);

   glShadeModel(GL_SMOOTH);

   glEnable(GL_LIGHT0);         // habilita luz 0
   glEnable(GL_COLOR_MATERIAL); // Utiliza cor do objeto como material
   //glColorMaterial(GL_FRONT_AND_BACK, GL_DIFFUSE);

   //habilita a luz ambiente
   GLfloat luzAmbiente[4] = {0.5, 0.5, 0.5, 1.0};
   glLightModelfv(GL_LIGHT_MODEL_AMBIENT, luzAmbiente);

   GLfloat posicaoLuz[4] = {0.0, 50.0, 100.0, 1.0};
   glLightfv(GL_LIGHT0, GL_POSITION, posicaoLuz);

   glEnable(GL_LIGHTING);   // Habilita luz
   glEnable(GL_DEPTH_TEST); // Habilita Z-buffer
   glEnable(GL_CULL_FACE);  // Habilita Backface-Culling
}

void desenha(void)
{
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

   glMatrixMode(GL_PROJECTION);
   glLoadIdentity();
   gluPerspective(60.0, (GLfloat)width / (GLfloat)height, 1.0, 200.0);

   glMatrixMode(GL_MODELVIEW);
   glLoadIdentity();
   gluLookAt(0.0, 0.0, distOrigem, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   glLineWidth(2.0);
   //desenha as linhas da borda
   glColor3f(1.0, 1.0, 1.0);
   glBegin(GL_LINE_STRIP);
   glVertex3f(-28.0, -21.2, 1.0);
   glVertex3f(28.0, -21.2, 1.0);
   glVertex3f(32.0, 10.0, -81.0);
   glVertex3f(-33.0, 10.0, -81.0);
   glVertex3f(-28.0, -21.2, 1.0);
   glEnd();

   glColor3f(1.0, 1.0, 0.0);
   glBegin(GL_QUADS);
   glVertex3f(-21.000000, -15.800000, 12.000000);
   glVertex3f(-11.400000, -21.000000, 1.200000);
   glVertex3f(-31.000000, -37.799999, -115.000000);
   glVertex3f(-24.000000, -12.000000, -6.000000);
   glVertex3f(-21.000000, -15.800000, 12.000000);
   glEnd();

   glColor3f(0.5, 0.5, 0.5);
   glBegin(GL_QUADS);
   glVertex3f(-11.5, -21.2, 1.0);  // 1
   glVertex3f(-8, -21.2, 1.0);     // 2
   glVertex3f(-10, 10, -81.0);     // 3
   glVertex3f(-13.5, 10.0, -81.0); // 4
   glVertex3f(-11.5, -21.2, 1.0);  // 5
   glEnd();

   glBegin(GL_QUADS);
   glVertex3f(6.200000, -16.000000, 11.800000);   // 1
   glVertex3f(35.300064, -65.000153, -90.199860); // 2
   glVertex3f(13.499995, 10.000000, -81.000000);  // 3
   glVertex3f(9.9, 10.000000, -81.000000);        // 4
   glVertex3f(6.200006, -16.000000, 11.800000);   // 5
   glEnd();

   glBegin(GL_QUADS);
   glVertex3f(-59.30, -29.60, -80.20);
   glVertex3f(58.50, -29.60, -80.20);
   glVertex3f(57.10, -26.40, -81.00);
   glVertex3f(-56.70, -26.20, -80.00);
   glVertex3f(-59.30, -29.60, -80.20);
   glEnd();

   glBegin(GL_QUADS);
   glVertex3f(-46.70, -10.80, -81.20);
   glVertex3f(46.30, -11.00, -81.20);
   glVertex3f(45.10, -8.60, -81.20);
   glVertex3f(-45.30, -8.60, -81.40);
   glVertex3f(-46.70, -10.80, -81.20);
   glEnd();

   glBegin(GL_QUADS);
   glVertex3f(-39.10, -0.40, -78.20);
   glVertex3f(39.10, -0.20, -80.60);
   glVertex3f(37.30, 2.40, -80.20);
   glVertex3f(-56.10, 3.40, -139.20);
   glVertex3f(-39.10, -0.40, -78.20);
   glEnd();


   //realiza as transforma��es e desenha o cubo
   glPushMatrix();
   glRotatef(25.0, 1.0, 0.0, 0.0);    //ajusta o angulo de rota��o do cubo
   glTranslatef(eixo_x, 1.0, eixo_z); //ajusta os eixos x e z de acordo com as setas
   glColor3f(0.80, 0.60, 0.0);
   glutSolidCube(10.0); //desenha o cubo
   glPopMatrix();

   printf("%.2f, %.2f, %.2f", a, b, c);

   glutSwapBuffers();
}

void idle()
{
   glutPostRedisplay();
}

void reshape(int w, int h)
{
   width = w;
   height = h;
   glViewport(0, 0, (GLsizei)w, (GLsizei)h);
}

void keyboard(unsigned char key, int x, int y)
{
   switch (key)
   {
   case 'a':
      a = a - 0.2;
      break;
   case 'A':
      a = a + 0.2;
      break;
   case 'b':
      b = b - 0.2;
      break;
   case 'B':
      b = b + 0.2;
      break;
   case 'c':
      c = c - 0.2;
      break;
   case 'C':
      c = c + 0.2;
      break;
   case 'O':
      printf("%.2f, %.2f, %.2f", a, b, c);
      break;
   }
}

void specialKeys(int key, int x, int y)
{
   float dist = 12;
   switch (key)
   {
   case GLUT_KEY_UP:
      //seta para cima
      eixo_z -= dist-1;
      if (eixo_z < -16.0)
         eixo_z = -16.0;
      break;
   case GLUT_KEY_DOWN:
      //seta para baixo
      eixo_z += dist-1;
      if (eixo_z > 17.0)
         eixo_z = 17.0;
      break;
   case GLUT_KEY_RIGHT:
      //seta para direita
      eixo_x += dist;
      if (eixo_x > 12.0)
         eixo_x = 12.0;
      break;
   case GLUT_KEY_LEFT:
      //seta para esquerda
      eixo_x -= dist;
      if (eixo_x < -12.0)
         eixo_x = -12.0;
      break;
   }
   glutPostRedisplay();
}

// Motion callback
// Movimenta o cubo com o mouse
void motion(int x, int y)
{
   //rotationX += (float) (y - last_y);
   //rotationY += (float) (x - last_x);

   //last_x = x;
   //last_y = y;
}

// Mouse callback
void mouse(int button, int state, int x, int y)
{
   if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
   {
      last_x = x;
      last_y = y;
   }
}

int main(int argc, char **argv)
{
   glutInit(&argc, argv);
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
   glutInitWindowSize(width, height);
   glutInitWindowPosition(100, 100);
   glutCreateWindow(argv[0]);
   init();
   glutDisplayFunc(desenha);
   glutReshapeFunc(reshape);
   glutMouseFunc(mouse);
   glutMotionFunc(motion);
   glutKeyboardFunc(keyboard);
   //teclas especiais
   glutSpecialFunc(specialKeys);
   glutIdleFunc(idle);
   glutMainLoop();
   return 0;
}
