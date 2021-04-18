package app.requirements;

import app.mapper.ShipdataMapper;
import app.model.SatellitesDataContainer;
import app.model.Satellitedata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSatellitesDataRequirement {

    @Autowired
    ShipdataMapper shipdataMapper;

    public SatellitesDataContainer getSatellitesData() {
        List<Satellitedata> satellites = shipdataMapper.selectAll();
        Satellitedata kenobi = satellites.get(0);
        Satellitedata skywalker = satellites.get(2);
        Satellitedata sato = satellites.get(1);

        Float[] distances = {kenobi.getDistance(),skywalker.getDistance(),sato.getDistance()};

        ArrayList<ArrayList<String>> messages = new ArrayList<>();
        satellites.stream().forEach(satellite -> {
            ArrayList<String> currentMessage = new ArrayList<>();
            currentMessage.clear();
            String str = satellite.getMessage();
            if(String.valueOf(str.charAt(satellite.getMessage().length() - 1)).equals(",")) {
                str = str + " ";
            }
            String[] message = str.split(",");
            for(int i  = 0; i < message.length; i ++) {
                if(String.valueOf(message[i]).equals("")) {
                    currentMessage.add(" ");
                }
                else {
                    currentMessage.add(message[i]);
                }
            }
            messages.add(currentMessage);
        });

        return new SatellitesDataContainer(distances,messages);
    }
}
