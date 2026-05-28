## Bartolomeu Costa (123779)
Não consigo fazer a parte dos Dev Containers porque a exntensão no IDE não funciona. ( Já mostrado ao prof na aula)

# Discoveries Battleship Game

Projeto desenvolvido no âmbito da unidade curricular de Engenharia de Software.

## Grupo

**Nickname:** TP05-11

| Curso | Número | Nome |
| --- | ---: | --- |
| LIGE | 110420 | Miguel Paiva |
| LIGE | 123779 | Bartolomeu Costa |
| LIGE | 122486 | Gonçalo Ordaz |
| LIGE | 124424 | Rodrigo Carraça |

## Descrição

Este projeto implementa uma versão em Java do jogo Batalha Naval, com uma frota inspirada na época dos Descobrimentos Portugueses. O projeto usa Maven para compilação, testes, empacotamento e geração de documentação.

## Regras do Jogo

O jogo é jogado numa grelha 10x10.

O sistema de coordenadas é:

```text
(x, y) ∈ {0,...,9} × {0,...,9}
```

Funcionamento geral:

1. Cada jogador posiciona a sua frota na sua grelha.
2. Os jogadores jogam alternadamente.
3. Em cada turno, o jogador dispara três tiros.
4. O adversário informa se cada tiro foi um acerto, uma falha ou se afundou um navio.
5. O jogador regista os resultados na grelha do adversário.
6. Ganha o jogador que afundar todos os navios do oponente.

## Frota

| Nome no jogo | Nome atual | Dimensão | Quantidade |
| --- | --- | ---: | ---: |
| Galeão | Porta-aviões | 5 | 1 |
| Fragata | Navio de 4 canhões | 4 | 1 |
| Nau | Navio de 3 canhões | 3 | 2 |
| Caravela | Navio de 2 canhões | 2 | 3 |
| Barca | Submarino | 1 | 4 |

## Contexto Histórico

Os navios utilizados no jogo foram inspirados na época dos Descobrimentos Portugueses:

- [Galeão](https://en.wikipedia.org/wiki/Galleon)
- [Fragata](https://en.wikipedia.org/wiki/Frigate)
- [Nau](https://en.wikipedia.org/wiki/Carrack)
- [Caravela](https://en.wikipedia.org/wiki/Caravel)
- [Barca](https://en.wikipedia.org/wiki/Barge)

## Requisitos

- Java 17
- Maven
- Docker, apenas para construir e executar a imagem do projeto

## Compilação e Testes

Para compilar o projeto:

```bash
mvn clean compile
```

Para executar os testes:

```bash
mvn test
```

Para gerar o ficheiro JAR:

```bash
mvn clean package
```

O JAR executável é criado em:

```text
target/BattleshipGame-2.0.jar
```

Para executar a aplicação localmente:

```bash
java -jar target/BattleshipGame-2.0.jar
```

## Docker

Depois de gerar o JAR, a imagem Docker pode ser criada com:

```bash
docker build -t battleship-game:latest .
```

Para executar a aplicação dentro de um contentor:

```bash
docker run --rm -i battleship-game:latest
```

O workflow `.github/workflows/docker-publish.yml` automatiza a criação e publicação da imagem Docker no Docker Hub.

## DevContainer

O projeto inclui uma pasta `.devcontainer/` com a configuração do ambiente de desenvolvimento. O DevContainer usa Java 17 e Maven, permitindo compilar, testar e executar o projeto num ambiente reproduzível.

Ficheiros principais:

- `.devcontainer/devcontainer.json`
- `.devcontainer/Dockerfile`

## Documentação

A documentação pública do projeto está na pasta `docs/`, preparada para GitHub Pages.

Página principal:

```text
docs/index.html
```

Javadoc:

```text
docs/apidocs/index.html
```

O Maven está configurado para gerar o site técnico em:

```text
docs/maven-site
```

Comando para gerar o site Maven:

```bash
mvn site
```

Comando para gerar o Javadoc:

```bash
mvn javadoc:javadoc
```

## Estado da Ficha 6

Tarefas já refletidas no repositório:

- Criação de imagem Docker para o jogo.
- Workflow de publicação da imagem Docker.
- Configuração de DevContainer.
- Publicação de documentação via pasta `docs/`.
- Página `index.html` visual para GitHub Pages.
- Javadoc gerado em `docs/apidocs`.

A pipeline completa da tarefa H será tratada num workflow próprio quando essa tarefa for desenvolvida.

## Notas de Git

**Working Area:** área onde os ficheiros são editados localmente.

**Staging Area:** área intermédia onde se colocam ficheiros com `git add` antes do commit.

**Local Repository:** repositório guardado no computador, atualizado com `git commit`.

**Remote Repository:** repositório remoto, normalmente no GitHub, atualizado com `git push`.

Comandos fundamentais:

- `git init`: cria um novo repositório Git.
- `git clone`: copia um repositório remoto.
- `git add`: adiciona ficheiros à staging area.
- `git commit`: guarda alterações no repositório local.
- `git push`: envia alterações para o repositório remoto.
- `git pull`: atualiza o repositório local com alterações remotas.

Branches:

- `git branch`: cria ou lista branches.
- `git checkout` / `git switch`: muda de branch.
- `git merge`: junta alterações de outra branch.
- `git rebase`: reaplica commits para manter um histórico mais linear.

Outros comandos úteis:

- `git stash`: guarda temporariamente alterações ainda não commitadas.
- `git tag`: marca versões importantes, como `v1.0`.

Modelos de branching:

- **GitHub Flow:** modelo simples baseado em branch, pull request e merge na `main`.
- **Git Flow:** modelo mais estruturado com branches `main`, `develop`, `feature`, `release` e `hotfix`.
