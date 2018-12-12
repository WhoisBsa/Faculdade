cidade(são_mateus,pequena).
cidade(vitória,média).
cidade(são_paulo,grande).
cidade(maceió,média).
cidade(campos,pequena).
cidade(cariacica,pequena).
cidade(colatina,pequena).
capital(vitória).
capital(maceió).
capital(sãopaulo).
capital(portoalegre).
estado(es,sudeste).
estado(al,nordeste).
estado(sp,sudeste).
pertence(são_mateus,es).
pertence(vitória,es).
pertence(santos,sp).
pertence(maceió,al).
pertence(colatina,es).
pertence(cariacica,es). 

cidadepequena(X) :- cidade(X, pequena).
cidade_na_regiao_norte(X) :- cidade(X, _), estado(_, norte).
capital_regiao_sul(X) :- capital(X), estado(_, sul).
cidade_pequena_regiao_sudeste(X) :- idade(X, pequena), estado(_, sudeste).
estado_com_capital_grande(X) :- capital(X), cidade(X, grande).
estado_regiao_nordeste_com_capital_media(X) :- capital(X), estado(_, nordeste), cidade(_, média).
 cidade_pequena_do_estado(X,Y) :- cidade(X, pequena), estado(Y,_). 