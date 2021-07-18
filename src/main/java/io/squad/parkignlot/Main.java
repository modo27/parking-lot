package io.squad.parkignlot;

import io.squad.parkignlot.exceptions.ParkingException;
import io.squad.parkignlot.exceptions.RequestNotFoundException;
import io.squad.parkignlot.services.RequestParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/mohitdokania/IdeaProjects/SquadParkingLot/src/main/java/io/squad/parkignlot/input.txt";
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        RequestParser parser = new RequestParser();
        while ((line = br.readLine()) != null) {
            try {
                parser.parseRequest(line);
            } catch (RequestNotFoundException | ParkingException e) {
                e.printStackTrace();
            }
        }
    }
}
