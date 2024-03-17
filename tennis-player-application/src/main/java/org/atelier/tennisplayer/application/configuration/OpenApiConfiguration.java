package org.atelier.tennisplayer.application.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Tennis players Atelier kata",
                version = "v1.0",
                description = "Cette API offre une gamme de services dédiée à la gestion des données " +
                        "des joueurs de tennis. Elle permet la récupération de la liste complète " +
                        "des joueurs, l'accès aux informations détaillées d'un joueur via son " +
                        "identifiant, ainsi que l'agrégation et la fourniture de statistiques " +
                        "approfondies concernant les joueurs, telles que le pays affichant le " +
                        "meilleur ratio de victoires, l'indice de masse corporelle moyen et la " +
                        "médiane de la taille des joueurs."
        ),
        servers = @Server(
                description = "dev",
                url = "http://localhost:8080"
        )
)
public class OpenApiConfiguration {
}
