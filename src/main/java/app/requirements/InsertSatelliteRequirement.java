package app.requirements;

import app.mapper.ShipdataMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class InsertSatelliteRequirement {

    @Autowired
    ShipdataMapper shipdataMapper;

    public void insertSatellite(String satelliteName, Float satelliteDistance, List<String> satelliteMessage) {
        String str = " ";
        for (String word : satelliteMessage) {
            str += word + ",";
        }
        str = str.substring(0, str.length() - 1);
        shipdataMapper.insertSatellite(satelliteName, satelliteDistance, str);
    }

}
