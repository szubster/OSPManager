package com.miniinf.OSPManager.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Szubster
 * Date: 05.11.12
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ISODateObjectMapper extends ObjectMapper {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @PostConstruct
    private void setupDate() {
        setDateFormat(format);
        getSerializationConfig().withDateFormat(format);
    }
}
