package org.atelier.tennisplayer.infrstructure.model;

import org.atelier.tennisplayer.domain.model.AdditionalData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DataTest {
    private static AdditionalData buildAdditionalData() {
        return AdditionalData.builder()
                .withRank(100)
                .withAge(20)
                .withPoints(2000)
                .withHeight(199)
                .withWeight(67)
                .withLast(List.of(1, 2, 3, 4))
                .build();
    }

    private static Data buildData() {
        return Data.builder()
                .withRank(100)
                .withAge(20)
                .withPoints(2000)
                .withHeight(199)
                .withWeight(67)
                .withLast(List.of(1, 2, 3, 4))
                .build();
    }

    @Test
    void should_map_to_additional_data() {
        // Arrange & Act
        var actual = buildData().toAdditionalData();

        // Assert
        assertThat(actual).isEqualTo(buildAdditionalData());
    }

}