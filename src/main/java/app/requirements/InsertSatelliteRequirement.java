package app.requirements;

import app.mapper.ShipdataMapper;
import app.model.InsertSatelliteRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class InsertSatelliteRequirement extends HandlerRequirement<InsertSatelliteRequest, Void>{

    @Autowired
    ShipdataMapper shipdataMapper;

    @Override
    public Void run(InsertSatelliteRequest request) {
        String str = " ";
        for (String word : request.getSatelliteMessage()) {
            str += word + ",";
        }
        str = str.substring(0, str.length() - 1);
        shipdataMapper.insertSatellite(request.getSatelliteName(), request.getSatelliteDistance(), str);
        return null;
    }

}
