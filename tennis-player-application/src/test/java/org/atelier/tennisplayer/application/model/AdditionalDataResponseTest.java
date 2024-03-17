package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.AdditionalData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AdditionalDataResponseTest {

    private static AdditionalDataResponse buildAdditionalDataResponse() {
        return AdditionalDataResponse.builder()
                .withRank(100)
                .withAge(20)
                .withPoints(2000)
                .withHeight(199)
                .withWeight(67)
                .withLast(List.of(1, 2, 3, 4))
                .build();
    }

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

    @Test
    void should_map_additionalData_from_domain() {
        // Arrange & Act
        var actual = AdditionalDataResponse.from(buildAdditionalData());

        //Assert
        assertThat(actual).isEqualTo(buildAdditionalDataResponse());
    }
}