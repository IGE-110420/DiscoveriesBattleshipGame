# Discoveries Battleship Game

## Grupo
**Nickname:** TP05-11

## Membros

| Curso | Nº | Nome |
|------|----|------|
| LIGE  | 110420 | Miguel Paiva |
| LIGE  | 123779 | Bartolomeu Costa |
| LIGE  | 122486 | Gonçalo Ordaz |
| LIGE  | 124424 | Rodrigo Carraça |

## Regras do Jogo

O jogo é jogado numa grelha 10x10.

O sistema de coordenadas é definido como:

(x, y) ∈ {0,...,9} × {0,...,9}

### Funcionamento:

1. Cada jogador posiciona a sua frota na sua grelha.
2. Os jogadores jogam alternadamente.
3. Em cada turno, o jogador dispara **três tiros**.
4. O adversário informa:
   - Acerto (hit)
   - Falha (miss)
   - Se um navio foi afundado
5. O jogador regista os resultados na grelha do adversário.
6. Ganha o jogador que afundar todos os navios do oponente.

##  Tipos de Navios

| Nome (Descobrimentos) | Nome Atual        | Dimensão | Quantidade |
|------------------------|------------------|----------|------------|
| Galeão                 | Porta-aviões     | 5        | 1          |
| Fragata                | Navio 4 canhões  | 4        | 1          |
| Nau                    | Navio 3 canhões  | 3        | 2          |
| Caravela               | Navio 2 canhões  | 2        | 3          |
| Barca                  | Submarino        | 1        | 4          |

## Contexto Histórico

Os navios utilizados neste jogo inspiram-se na época dos Descobrimentos Portugueses.

- [Galeão](https://en.wikipedia.org/wiki/Galleon)
- [Fragata](https://en.wikipedia.org/wiki/Frigate)
- [Nau](https://en.wikipedia.org/wiki/Carrack)
- [Caravela](https://en.wikipedia.org/wiki/Caravel)
- [Barca](https://en.wikipedia.org/wiki/Barge)



## Respostas ás perguntas teóricas

##D.1:

Working area, staging area, local e remote repository

Working Area: é a área onde editamos os ficheiros no nosso computador.

Staging Area: é a área intermédia onde colocamos os ficheiros antes de fazer commit, usando git add.

Local Repository: é o repositório que está no nosso computador. O git commit guarda alterações aqui.

Remote Repository: é o repositório no GitHub. O git push envia as alterações para lá.

##D.2:

Comandos fundamentais

git init – cria um novo repositório Git.
git clone – copia um repositório remoto para o computador.
git add – adiciona ficheiros à staging area.
git commit – guarda alterações no repositório local.
git push – envia alterações para o repositório remoto.
git pull – atualiza o repositório local com alterações do remoto.

##E.1:

Criar, alternar e unir branches

Uma branch é uma linha de desenvolvimento independente.

branch – cria uma nova branch.
checkout – muda para outra branch.
merge – junta alterações de uma branch noutra.
rebase – reaplica commits de uma branch sobre outra, mantendo o histórico mais linear.

##E.2:

Simulação de conflito

Um conflito ocorre quando duas pessoas alteram a mesma parte de um ficheiro.

O Git marca o conflito no ficheiro com separadores.
É necessário editar manualmente o ficheiro, escolher a versão correta e remover as marcações.
Depois faz-se git add, git commit e git push.

##F.1:

git stash

O git stash permite guardar temporariamente alterações que ainda não queremos fazer commit.
É útil quando precisamos mudar de branch sem perder trabalho.

##F.2:

git tag

O git tag serve para marcar versões importantes do projeto, como v1.0.
Permite identificar releases ou versões estáveis.

##F.3:

Modelos de branching

GitHub Flow – modelo simples baseado em branch + pull request + merge na main. Adequado para projetos pequenos.

Git Flow – modelo mais estruturado com branches main, develop, feature, release e hotfix. Usado em projetos maiores.
