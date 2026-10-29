# Monsters & Spellbooks 0.0.14 for Minecraft 1.20.1 (Forge): unofficial port, build b2

## English

### b2

- **Epic Fight:** the game no longer crashes at startup when Epic Fight is installed. The Focus effect locked the camera by redirecting the same mouse call Epic Fight redirects, and two redirects on one call can't both apply. The camera lock now works another way, and it still locks the camera with Epic Fight installed, with or without Better Combat.

### b1

**Monsters & Spellbooks** by **RedReaper (RedTablos)** is now on **Minecraft 1.20.1 with Forge**. It is the same mod as version 0.0.14 for NeoForge 1.21.1: the 98 spells, the **Necro** and **Aero** schools, the 33 creatures, the gear, the structures (Draugr Camp and Herobrine Shrine), the ores, the blocks and the loot. The original is MIT-licensed and this port keeps that license and the credits.

### What's different from 1.21.1

Some vanilla things in the original only exist from Minecraft 1.21 on, so the port replaces them:

- **Maces:** 1.20.1 has no vanilla mace. The **Endersent Crusher** and the **Paladin Hammer** run on the port's own mace. Hit while falling more than 1.5 blocks and the fall becomes extra damage. The blow also stops your fall, knocks back the creatures around the target and throws up a burst of dust. Maces take the weapon enchantments (Sharpness, Smite, Bane of Arthropods, Fire Aspect, Knockback, Looting) plus Unbreaking and Mending.
- **New item: Heavy Mace.** Its recipe is 2 iron ingots and 1 iron block on top, with 2 blaze rods as the handle. It replaces the vanilla mace in the Endersent Crusher and Paladin Hammer recipes.
- **Wind Charge spell:** 1.20.1 has no vanilla wind charge either. The spell now fires its own projectile, which leaves a trail of cloud and bursts with knockback when it hits.
- **Size:** 1.20.1 has no size attribute, so the port does sizes itself:
  - The **Draugr Elite Vindicator** is still 1.2 times bigger, in both model and hitbox.
  - **Endersent Strength** (Endersent Form) still makes you 2.5 times bigger, in model, hitbox and eye height.
- **Inflammable** still makes fire last 5% longer per level.
- **Prismarine weapons:** 1.20.1 has no Water Movement Efficiency, Oxygen Bonus or Submerged Mining Speed. Forge's Swim Speed takes the place of water movement:
  - Prismarine Claymore: +0.15 swim speed.
  - Prismarine Axe: +0.10 swim speed.
  - Necromancer's prismarine weapon: +20% swim speed.
  - The oxygen and underwater mining bonuses are gone.
- **Draugr Camp:** its copper trapdoors (a 1.21 block) are iron trapdoors.
- **Trial Chambers** don't exist in 1.20.1, so the loot the mod adds there never shows up.
- **Undead allies:** 1.20.1 has no undead entity tag, so the Draugr allies list names the vanilla undead one by one.

### Fixes over 0.0.14

- **Crash fixes:**
  - Casting **Poison Quill** or **Razorblade Typhoon** no longer crashes the game. Their animation files were missing.
  - A **Soul Chain** loaded back from a saved world with no target no longer crashes the server.

### Requirements

- Minecraft **1.20.1**, Forge **47.2+**
- **Iron's Spells 'n Spellbooks 1.20.1-3.16.3+**, plus what it needs (Curios, GeckoLib, Player Animator, Iron's Lib, Caelus)
- **Ace's Spell Utils** for 1.20.1 (1.1.0+)
- **AzureLib** for 1.20.1 (3.2+)

### Credits

- **Monsters & Spellbooks:** RedReaper (RedTablos), MIT License.
- Two mob base classes are adapted from **Ace's Spell Utils** 1.21.1 by AceTheEldritchKing (MIT). The 1.20.1 version of Ace's Spell Utils doesn't have them.

---

## Português

### b2

- **Epic Fight:** o jogo não crasha mais ao abrir com o Epic Fight instalado. O efeito Focus travava a câmera redirecionando a mesma chamada do mouse que o Epic Fight redireciona, e dois redirecionamentos na mesma chamada não podem valer juntos. A trava da câmera agora funciona de outro jeito, e continua travando com o Epic Fight instalado, com ou sem Better Combat.

### b1

**Monsters & Spellbooks**, do **RedReaper (RedTablos)**, agora roda no **Minecraft 1.20.1 com Forge**. É o mesmo mod da versão 0.0.14 para NeoForge 1.21.1: os 98 feitiços, as escolas **Necro** e **Aero**, as 33 criaturas, os equipamentos, as estruturas (Draugr Camp e Herobrine Shrine), os minérios, os blocos e o loot. O original é licença MIT; este port mantém a licença e os créditos.

### O que muda em relação à 1.21.1

Algumas coisas vanilla que o original usa só existem a partir do Minecraft 1.21, então o port coloca substitutos:

- **Maças:** a 1.20.1 não tem a maça vanilla. O **Endersent Crusher** e o **Paladin Hammer** usam uma maça própria do port. Bater caindo de mais de 1,5 bloco transforma a queda em dano extra. O golpe também para a queda, empurra as criaturas em volta do alvo e levanta uma nuvem de poeira. As maças aceitam os encantamentos de arma (Afiação, Julgamento, Ruína dos Artrópodes, Aspecto Flamejante, Repulsão, Pilhagem), além de Inquebrável e Remendo.
- **Item novo: Heavy Mace (Maça Pesada).** A receita é 2 barras de ferro e 1 bloco de ferro em cima, com 2 varas de blaze de cabo. Ela substitui a maça vanilla nas receitas do Endersent Crusher e do Paladin Hammer.
- **Feitiço Wind Charge:** a 1.20.1 também não tem a carga de vento vanilla. O feitiço agora dispara um projétil próprio, que deixa um rastro de nuvem e explode com repulsão ao acertar.
- **Tamanho:** a 1.20.1 não tem o atributo de tamanho, então o port faz o tamanho por conta própria:
  - O **Draugr Elite Vindicator** continua 1,2 vez maior, no modelo e na hitbox.
  - **Endersent Strength** (Endersent Form) continua deixando você 2,5 vezes maior, no modelo, na hitbox e na altura dos olhos.
- **Inflammable** continua fazendo o fogo durar 5% a mais por nível.
- **Armas de prismarinho:** a 1.20.1 não tem Water Movement Efficiency, Oxygen Bonus nem Submerged Mining Speed. A Velocidade de Nado do Forge entra no lugar do movimento na água:
  - Prismarine Claymore: +0,15 de velocidade de nado.
  - Prismarine Axe: +0,10 de velocidade de nado.
  - Arma de prismarinho do Necromancer: +20% de velocidade de nado.
  - Os bônus de oxigênio e de mineração debaixo d'água saíram.
- **Draugr Camp:** os alçapões de cobre (bloco da 1.21) viraram alçapões de ferro.
- **Trial Chambers** não existem na 1.20.1, então o loot que o mod adiciona lá nunca aparece.
- **Aliados mortos-vivos:** a 1.20.1 não tem a tag de entidade de mortos-vivos, então a lista de aliados dos Draugr cita os mortos-vivos vanilla um por um.

### Correções em relação à 0.0.14

- **Correções de crash:**
  - Lançar **Poison Quill** ou **Razorblade Typhoon** não derruba mais o jogo. Faltavam os arquivos de animação deles.
  - Uma **Soul Chain** carregada de um mundo salvo sem alvo não derruba mais o servidor.

### Requisitos

- Minecraft **1.20.1**, Forge **47.2+**
- **Iron's Spells 'n Spellbooks 1.20.1-3.16.3+** e o que ele pede (Curios, GeckoLib, Player Animator, Iron's Lib, Caelus)
- **Ace's Spell Utils** para 1.20.1 (1.1.0+)
- **AzureLib** para 1.20.1 (3.2+)

### Créditos

- **Monsters & Spellbooks:** RedReaper (RedTablos), licença MIT.
- Duas classes-base de mob foram adaptadas do **Ace's Spell Utils** 1.21.1, do AceTheEldritchKing (MIT). A versão 1.20.1 do Ace's Spell Utils não tem essas classes.
