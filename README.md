# email_poll
Eletronic vote system, using email


Sejam os casos de uso (funcionalidades) abaixo para o sistema:
* um usuário cria um grupo, e dá um nome a ele. Por exemplo:
"professores da POLI".
* para esse grupo o usuário dono do grupo importa uma base de dados com
email;nome das pessoas que poderão votar (supostamente professores, mas
poderia ser qualquer um).
Há mais algum campo que deveríamos importar?
* O dono do grupo cria uma enquete (uma pergunta de múltipla escolha).
* O dono do grupo dispara a enquete.
O sistema manda email para cada um da lista, com um link para cada opção
da enquete.
Os links devem contar chaves aleatórias, para que seja improvável um
hacker deduzir quais seriam esses links.
Cada pessoa que recebe email, decide em o que quer votar, e clica no
link correspondente.
O sistema registra o voto do que for clicado.
* O sistema lista a reportagem de pessoas, emails e votos.

Acho que poderia ser aberta e voluntária, mas com aquelas letrinhas para confirmar que não é robô votando ;-) 

