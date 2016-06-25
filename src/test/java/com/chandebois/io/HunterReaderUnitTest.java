package com.chandebois.io;

import com.chandebois.domain.Position;
import com.chandebois.io.model.HunterReaderModel;
import com.chandebois.orientation.OrientationEast;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.util.List;

/**
 * Created by nonok on 25/06/2016.
 */
public class HunterReaderUnitTest {
    @Test
    public void should_read_file_and_initialize_hunter_reader_model() throws Exception {
        HunterReader hunterReader = new HunterReader();
        List<HunterReaderModel> hunterReaderModels = hunterReader.read(ResourceUtils.getFile("classpath:hunter.txt"));
        Position startPosition = new Position();
        Assertions.assertThat(hunterReaderModels).isNotEmpty();
        Assertions.assertThat(hunterReaderModels.get(0).getOrientation()).isInstanceOf(OrientationEast.class);
        Assertions.assertThat(hunterReaderModels.get(0).getPosition()).isEqualTo(startPosition);
        Assertions.assertThat(hunterReaderModels.get(0).getCommands()).isNotEmpty();
    }
}
