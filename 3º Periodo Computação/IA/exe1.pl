mulher(ana).
mulher(eva).
mulher(clo).
mulher(bia).
mulher(lia).
mulher(gal).
homem(ivo).
homem(noe).
homem(rai).
homem(gil).
homem(ary).
pai(ivo,eva).
pai(gil,rai).
pai(gil,clo).
pai(gil,ary).
pai(rai,noe).
pai(ary,gal).
mae(ana,eva).
mae(bia,rai).
mae(bia,clo).
mae(bia,ary).
mae(eva,noe).
mae(lia,gal).

gerou(X,Y) :- mae(X,Y); pai(X,Y).
filha(X,Y) :- mae(X,Y); pai(X,Y), mulher(Y).
filho(X,Y) :- mae(X,Y); pai(X,Y), homem(Y).
avo(X,Y) :- pai(X,P), (pai(P,Y); mae(P,Y)), homem(X).
ava(X,Y) :- mae(X,P), (pai(P,Y); mae(P,Y)), mulher(X).
tio(X,Y) :- pai(P,X), (pai(Z,P); mae(Z,P)), pai(Z,Y), Y \= P.
tia(X,Y) :- mae(P,X), (pai(Z,P); mae(Z,P)), pai(Z,Y), Y \= P.
primo(X,Y) :- (pai(P,Z); mae(P,Z)), (pai(P,D); mae(P,D)), (pai(P,X); mae(P,X)), (pai(Z,Y); mae(Z,Y)), homem(X).
prima(X,Y) :- (pai(P,Z); mae(P,Z)), (pai(P,D); mae(P,D)), (pai(P,X); mae(P,X)), (pai(Z,Y); mae(Z,Y)), mulher(X). 
feliz(X,Y) :- pai(X,Y); mae(X,Y).
casal(X,Y) :- pai(X,F), mae(Y,F).
