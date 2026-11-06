# TownyUpgradeableHoppers

A Minecraft Paper plugin that adds [Towny](https://github.com/TownyAdvanced/Towny) support for [UpgradeableHoppers](https://www.spigotmc.org/resources/upgradeable-hoppers-⭕-fast-hopper-plugin-link-containers-✅-item-transfer-suction-chunk-26-x-suppor.69201/) to prevent picking up items in claims where players do not have permissions. The upgradeable hoppers will not be able to pick up items in personally owned plots, nation zones where the player is not a member, and town-owned plots unless the player is the mayor or has an assistant-like rank.

Assistant-like ranks can be added to `rank_names_to_be_treated_as_assistants` in Towny's config.yml.

## Dependencies

- [Towny](https://github.com/TownyAdvanced/Towny)
- [UpgradeableHoppers](https://www.spigotmc.org/resources/upgradeable-hoppers-⭕-fast-hopper-plugin-link-containers-✅-item-transfer-suction-chunk-26-x-suppor.69201/)

## Building

If you wish to build the plugin yourself, follow the instructions below.

1. Clone the repository:
    ```shell
    git clone https://github.com/SulkyWhale/TownyUpgradeableHoppers.git
    ```
2. Change into the project directory:
    ```shell
    cd TownyUpgradeableHoppers
    ```
3. Build the JAR with Maven:
    ```shell
    mvn clean package
    ```

## Issues and Suggestions

If you encounter any bugs, please open an [issue](https://github.com/SulkyWhale/TownyUpgradeableHoppers/issues/new). Be sure to check existing issues first to avoid duplicates.

If you have a feature request, please start a [discussion](https://github.com/SulkyWhale/TownyUpgradeableHoppers/discussions/new?category=ideas) to share your idea!

## Contributing

Contributions are welcome. If you have any bug fixes, improvements, or new features you would like to add to this project, feel free to open a [pull request](https://github.com/SulkyWhale/TownyUpgradeableHoppers/pulls). For new features, it is recommended to start a [discussion](https://github.com/SulkyWhale/TownyUpgradeableHoppers/discussions/new?category=ideas) first to discuss it, so that it can be evaluated before any time is invested into it.

## License

TownyUpgradeableHoppers is licensed under the GNU GPL-3.0-only. Please see the [license](/LICENSE.md) for more information.
