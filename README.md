# Examen rattrapage JEE 09/2015


## Modalités de rendu : 1 point

Pour rendre votre travail, vous devrez :

 * Implémenter les différentes méthodes demandées
 * Modifier dans le fichier `pom.xml` le nom de l'artifactId sous la forme suivante :

     <artifactId>exam-JEE-2015-NOM-PRENOM</artifactid>

   Remplacer les espaces et tout caractère non alphanumérique dans le nom et prénom par un `-`. Par exemple : `Gérard D'Orimont de Haute Cloque` donnera :

     <artifactId>exam-JEE-2015-D-ORIMONT-DE-HAUTE-CLOQUE-GERARD</artifactid>

 * Zipper le répertoire de travail sans le répertoire `target` et renommer le fichier :

     exam-JEE-2015-NOM-PRENOM.zip

 * Envoyer le fichier zip à `dmetzler@gmail.com` avec comme sujet `Exam JEE Rattrapage 2015 : Nom Prénom`



## Première partie : TDD sur 12 points

Dans cette première partie, on développera une librairie permettant de compter les points d'une partie de MasterMind. Vous devrez implémenter les tests proposés pour ensuite implémenter la librairie elle même.


### Règles du MasterMind

cd https://fr.wikipedia.org/wiki/Mastermind

#### Présentation

Le jeu se présente généralement sous la forme d'un plateau perforé de 10 rangées de quatre trous pouvant accueillir des pions de couleurs.

Le nombre de pions de couleurs différentes est de 8 et les huit couleurs sont généralement : rouge ; jaune ; vert ; bleu ; orange ; blanc ; violet ; fuchsia.

Il y a également des pions blancs et rouges (ou noirs) utilisés pour donner des indications à chaque étape du jeu.

Il existe de nombreuses variantes suivant le nombre de couleurs, de rangées ou de trous.

#### Principe

Un joueur commence par placer son choix de pions sans qu'ils soient vus de l'autre joueur à l'arrière d'un cache qui les masquera à la vue de celui-ci jusqu'à la fin de la manche.

Le joueur qui n'a pas sélectionné les pions doit trouver quels sont les quatre pions, c'est-à-dire leurs couleurs et positions.

Pour cela, à chaque tour, le joueur doit se servir de pions pour remplir une rangée selon l'idée qu'il se fait des pions dissimulés.

Une fois les pions placés, l'autre joueur indique :

le nombre de pions de la bonne couleur bien placés en utilisant le même nombre de pions rouges ;
le nombre de pions de la bonne couleur, mais mal placés, avec les pions blancs.
Il arrive donc surtout en début de partie qu'il ne fasse rien concrètement et qu'il n'ait à dire qu'aucun pion ne correspond, en couleur ou en couleur et position.

La tactique du joueur actif consiste à sélectionner en fonction des coups précédents, couleurs et positions, de manière à obtenir le maximum d'informations de la réponse du partenaire puisque le nombre de propositions est limité par le nombre de rangées de trous du jeu. Dans la plupart des cas, il s'efforce de se rapprocher le plus possible de la solution, compte tenu des réponses précédentes, mais il peut aussi former une combinaison dans le seul but de vérifier une partie des conclusions des coups précédents et de faire en conséquence la proposition la plus propice à la déduction d'une nouvelle information.

Le joueur gagne cette manche s'il donne la bonne combinaison de pions sur la dernière rangée ou avant. Dans tous les cas, c'est à son tour de choisir les pions à découvrir.


### Tests

Vous disposez dans le projet Maven de trois classes:

 * `MasterMind` : le contrat que doit suivre la partie, cette interface ne doit pas être modifiée.
 * `MasterMind` : l'implémentation de l'interface précédente que vous allez coder.
 * `MasterMindTest` : la classe contenant des méthodes de test vides.

En prenant un test à la fois, implémenter le corps de celui-ci en fonction de la description contenue dans la javadoc des différentes méthodes de test.

Compléter ensuite MasterMindImpl pour que le test passe, puis passer au test suivant.


## Deuxième partie : Servlet sur 8 points

A l'aide d'une servlet, on exposera la librairie précédente pour pouvoir initialiser une partie et d'autre part
récupérer le résultat d'un essai.

Pour cet exercice, vous disposez de deux classes :

 * `MasterMindServlet` : la classe qui doit être une servlet et répondre à l'URL /game
 * `MasterMindTest` : une classe de test déjà remplie qui doit vous aider à valider votre servlet.

Suivre les instructions présentes dans la Javadoc de chaque test. Le harnais de test (`JettyHarness`) lance déjà la servlet dans un micro container pendant le test.

### Indices

On utilisera le mécanisme de la session web (HttpRequest#getSession()) dans lequel on pourra stocker l'état courant du jeu (setAttribute() et getAttribute()). Par exemple :

  MasterMind mm = (MasterMind) req.getSession().getAttribute("game");

