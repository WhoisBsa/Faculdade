# !/bin/bash

echo -e "Instalando arquivos.
Isso pode demorar um pouco...\n\n"

if ! (apt-get update -y)
then
    echo -e "\n\nNão foi possível atualizar os repositórios. Verifique seu arquivo /etc/apt/sources.list\n\n"
    exit 1
fi
echo -e "\n\nAtualização feita com sucesso\n\n"

echo -e "\n\nAtualizando pacotes já instalados\n\n"
if ! (apt-get dist-upgrade -y)
then
    echo -e "\n\nNão foi possível atualizar pacotes.\n\n"
    exit 1
fi
echo "\n\nAtualização de pacotes feita com sucesso\n\n"


# Arquivos a serem instalados
vetor=(
  google-chrome-stable 
  code 
  spotify-client 
  telegram-desktop 
  slack-desktop 
  peek 
  sublime-text 
  whatsapp-desktop
  git
  npm
  hugo
  mysql-server
  mysql-workbench
)

for i in "${vetor[@]}"
do
    echo -e "\n\nInstalando $i\n\n"
    if ! (apt-get install $i -y)
    then
        echo -e "\n\nNão foi possível instalar o pacote $1\n\n"
    else
        echo -e "\n\nInstalação de $i finalizada\n\n"
    fi 
done


# Instalar libs do python
if ! pip3 install -r libspip.txt
then
  echo -e "\n\nAlguma coisa deu errado!\n\n"
else
  ehco -e "Libs instaladas com sucesso"
fi


# Configurar ssh ja adicionada no computador
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa


# Adicionar repositorios github
cd Documentos/

repositorios=(
  Faculdade.git
  WhoisBsa.github.io.git
  Curso-de-Python.git
  javascriptcourse.git
  op-website-hugo.git
  op-desafios.git
  Projects-Book-Automate.git
)

git config --global user.name "WhoisBsa"
git config --global user.email mbscbsjbs@gmail.com
git config --global core.editor vim
git config --global merge.tool vimdiff
git config --global core.excludesfile ~/.gitignore


# Clona todos os repositórios que adicionados no array
for i in "${repositorios[@]}"
do
    echo -e "\n\nInstalando $i\n\n"
    if ! (git clone https://github.com/WhoisBsa/$i )
    then
      echo -e "\n\nNão foi possível instalar o repositorio $1\n\n"
    else
      chmod -R 777 ${i//.git}
        echo -e "\n\nInstalação de $i finalizada\n\n"
    fi 
done

git clone https://whoisbsa@bitbucket.org/pic_unipac/portal_ensino.git


# Seta a ssh para todos os repositórios
for i in "${repositorios[@]}"
do
    echo -e "\n\Adicionando ssh para $i\n\n"
    cd ${i//.git}
    if ! (git remote set-url origin git@github.com:WhoisBsa/$i )
    then
      echo -e "\n\nNão foi possível adicionar a chave para $1\n\n"
    else
        echo -e "\n\Chave ssh de $i adicionada\n\n"
    fi 
    cd ..
done

cd portal_ensino.git
git remote set-url origin git@bitbucket.org:pic_unipac/portal_ensino.git
cd ..

cd op-desafios
git remote add upstream https://github.com/OsProgramadores/op-desafios


# Aliases para o git
git config --global alias.com commit
git config --global alias.s status
git config --global alias.pp push
git config --global alias.pl pull
git config --global alias.graph log --oneline --graph


# Volta pra HOME
cd ~
