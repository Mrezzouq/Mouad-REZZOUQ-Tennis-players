package org.atelier.tennisplayer.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.atelier.tennisplayer.application.model.PlayersResponse;
import org.atelier.tennisplayer.application.model.StatisticsResponse;
import org.atelier.tennisplayer.application.model.TennisPlayerResponse;
import org.atelier.tennisplayer.domain.port.in.TennisPlayerUseCase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("v1/tennis-player")
@Tag(name = "Tennis players API", description = "API pour la gestion des joueurs de tennis et la récupération de statistiques.")
public class TennisPlayerController {
    private final TennisPlayerUseCase tennisPlayerUseCase;

    public TennisPlayerController(TennisPlayerUseCase tennisPlayerUseCase) {this.tennisPlayerUseCase = tennisPlayerUseCase;}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Récupérer une liste triée de joueurs de tennis")
    @ApiResponse(responseCode = "200", description = "Liste de joueurs récupérée avec succès",
            content = @Content(
                    schema = @Schema(implementation = PlayersResponse.class)))
    public ResponseEntity<PlayersResponse> retrieveSortedPlayers() {
        var players = tennisPlayerUseCase.retrieveSortedPlayers();
        var response = PlayersResponse.builder()
                .withTennisPlayers(players.stream().map(TennisPlayerResponse::from).toList())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Récupérer un joueur par son identifiant")
    @ApiResponse(responseCode = "200", description = "Joueur récupéré avec succès",
            content = @Content(
                    schema = @Schema(implementation = TennisPlayerResponse.class)))
    @ApiResponse(responseCode = "404", description = "Joueur non trouvé")

    public ResponseEntity<TennisPlayerResponse> retrievePlayerById(
            @PathVariable @NotBlank @Parameter(description = "Identifiant d'un joueur") int playerId) {
        var result = tennisPlayerUseCase.retrievePlayerById(playerId);
        return result.map(player -> ResponseEntity.ok(TennisPlayerResponse.from(player)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Récupérer les statistiques des joueurs de tennis")
    @ApiResponse(responseCode = "200", description = "Statistiques récupérées avec succès",
            content = @Content(schema = @Schema(implementation = StatisticsResponse.class)))
    public ResponseEntity<StatisticsResponse> retrieveStatistics() {
        var statistics = tennisPlayerUseCase.retrieveStatistics();
        return ResponseEntity.ok(StatisticsResponse.from(statistics));
    }
}
