echo "Instalando arquivos.
Isso pode demorar um pouco..."

# Arquivos a serem instalados
vetor=(google-chrome-stable 
       code 
       spotify-client 
       telegram-desktop 
       slack-desktop 
       peek 
       sublime-text 
       whatsapp-desktop)

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
