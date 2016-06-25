package com.chandebois.io;

import com.chandebois.domain.TreasureMap;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

/**
 * Created by nonok on 25/06/2016.
 */
public class TreasureMapReaderUnitTest {
    @Test
    public void shuld_read_file_and_initialize_hunter_reader_model() throws Exception {
        TreasureMapReader treasureMapReader = new TreasureMapReader();
        TreasureMap treasureMap = treasureMapReader.read(ResourceUtils.getFile("classpath:treasure-map.txt"));
        Assertions.assertThat(treasureMap).isNotNull();
        Assertions.assertThat(treasureMap.getWidth()).isEqualTo(6);
        Assertions.assertThat(treasureMap.getHeight()).isEqualTo(5);
    }
}
