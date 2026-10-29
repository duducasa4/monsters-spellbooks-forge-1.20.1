# Monsters & Spellbooks: Forge 1.20.1 port

An unofficial **Forge 1.20.1** port of [Monsters & Spellbooks](https://www.curseforge.com/minecraft/mc-mods/monsters-spellbooks-iss) by **RedReaper (RedTablos)**, an addon for [Iron's Spells 'n Spellbooks](https://www.curseforge.com/minecraft/mc-mods/irons-spells-n-spellbooks). The original mod is made for NeoForge 1.21.1 and released under the MIT License. This port keeps that license and the credits. All of the mod's content is RedReaper's; the port only makes it run on 1.20.1.

*Versão em português mais abaixo.*

## What's in this port

The same mod as version 0.0.14 for NeoForge 1.21.1: 98 spells, the **Necro** and **Aero** schools, 33 creatures, the gear, the structures (Draugr Camp and Herobrine Shrine), the ores, the blocks and the loot.

Some vanilla things the original uses only exist from Minecraft 1.21 on, so the port replaces them:

- **Maces:** 1.20.1 has no mace. The Endersent Crusher and the Paladin Hammer run on the port's own mace (`compat120/ace/ModMaceItem`): a hit while falling turns the fall into extra damage and knocks back the creatures around the target.
- **Heavy Mace:** a new craftable item that takes the vanilla mace's place in their recipes.
- **Wind Charge:** the spell fires its own wind projectile (`entity/spells/wind_charge`).
- **Size:** 1.20.1 has no size attribute, so `compat120/ScaleCompat` and `compat120/client/ScaleRenderCompat` scale the model, the hitbox and the eye height (Endersent Form, Draugr Elite Vindicator).
- **Prismarine weapons:** Forge's Swim Speed takes the place of 1.21's water attributes.

The full list of differences and fixes is in [CHANGELOG.md](CHANGELOG.md).

## Requirements (to play)

- Minecraft **1.20.1**, Forge **47.2+**
- **Iron's Spells 'n Spellbooks** 1.20.1-3.16.3 or newer, and its dependencies (Curios, GeckoLib, Player Animator, Iron's Lib, Caelus)
- **Ace's Spell Utils** for 1.20.1 (1.1.0+)
- **AzureLib** for 1.20.1 (3.2+)

## Building

You need **JDK 17**. Then:

```
./gradlew build          (Linux / macOS)
gradlew.bat build        (Windows)
```

The jar ends up in `build/libs/`. The first build downloads Minecraft, Forge and the other mods it compiles against (Iron's Spells, Iron's Lib, GeckoLib, Curios, AzureLib, Ace's Spell Utils, Player Animator and JEI) from their public mavens; their versions are in `gradle.properties`. No jar of another mod is kept in this repository.

## Project layout

- `src/main/java/net/redreaper/monsterspellbooks/`: the mod, with the original packages and names.
- `compat120/`: code written for the port, standing in for 1.21 APIs and vanilla features that 1.20.1 doesn't have.
- `compat120/ace/`: two mob base classes adapted from Ace's Spell Utils 1.21.1 (MIT, AceTheEldritchKing), which its 1.20.1 version doesn't have, plus the port's mace items.
- `datagen/` and `worldgen/`: the original 1.21.1 data generators, kept for reference and left out of the build (see `build.gradle`). The data they made is already in `src/generated/resources`.

## Credits and license

- **Monsters & Spellbooks:** RedReaper (RedTablos), MIT License. Please support the original mod.
- **Ace's Spell Utils:** AceTheEldritchKing, MIT License (two adapted classes).
- **Forge 1.20.1 port:** RPGEmperor.

Released under the [MIT License](LICENSE).

---

# Monsters & Spellbooks: port para Forge 1.20.1

Um port não oficial para **Forge 1.20.1** do [Monsters & Spellbooks](https://www.curseforge.com/minecraft/mc-mods/monsters-spellbooks-iss), do **RedReaper (RedTablos)**, um addon do [Iron's Spells 'n Spellbooks](https://www.curseforge.com/minecraft/mc-mods/irons-spells-n-spellbooks). O mod original é feito para NeoForge 1.21.1 e lançado sob a licença MIT. Este port mantém a licença e os créditos. Todo o conteúdo é do RedReaper; o port só faz ele rodar na 1.20.1.

## O que muda em relação à 1.21.1

- **Maças:** a 1.20.1 não tem maça. O Endersent Crusher e o Paladin Hammer usam uma maça própria do port: bater caindo transforma a queda em dano extra e empurra as criaturas em volta do alvo.
- **Heavy Mace (Maça Pesada):** um item novo craftável que entra no lugar da maça vanilla nas receitas deles.
- **Wind Charge:** o feitiço dispara um projétil de vento próprio.
- **Tamanho:** sem o atributo de tamanho da 1.21, o port escala o modelo, a hitbox e a altura dos olhos por conta própria (Endersent Form, Draugr Elite Vindicator).
- **Armas de prismarinho:** a Velocidade de Nado do Forge entra no lugar dos atributos de água da 1.21.

A lista completa está no [CHANGELOG.md](CHANGELOG.md).

## Como compilar

Precisa do **JDK 17**. Depois rode `./gradlew build` (ou `gradlew.bat build` no Windows). O jar sai em `build/libs/`. O primeiro build baixa o Minecraft, o Forge e os mods usados na compilação dos mavens públicos deles; as versões estão no `gradle.properties`. Nenhum jar de outro mod fica neste repositório.

## Créditos e licença

- **Monsters & Spellbooks:** RedReaper (RedTablos), licença MIT. Apoie o mod original.
- **Ace's Spell Utils:** AceTheEldritchKing, licença MIT (duas classes adaptadas).
- **Port para Forge 1.20.1:** RPGEmperor.

Lançado sob a [licença MIT](LICENSE).
