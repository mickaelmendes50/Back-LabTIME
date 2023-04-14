package ufg.labtime.backend.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ufg.labtime.backend.entity.Usuario;

import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVUtils {

    public static List<Usuario> parse(){
        final String CSV_PATH = "C:\\GitHub\\backend\\src\\main\\assets\\usuarios.csv";
        try{
            CSVReader reader = new CSVReaderBuilder(new FileReader(CSV_PATH)).
                    withSkipLines(1). // Skiping firstline as it is header
                            build();
            List<Usuario> usuarios = reader.readAll().stream().map(data -> {
                Usuario user = new Usuario();
                user.setFullName(data[0]);
                user.setSocialName(data[1]);
                if (!data[2].equals(""))
                    user.setBirthDate(data[2]);
                user.setCode(data[3]);
                if (!data[4].equals(""))
                    user.setSex(data[4]);
                user.setEmail(data[5]);
                if (!data[6].equals(""))
                    user.setState(data[6]);
                if (!data[7].equals(""))
                    user.setCity(data[7]);
                user.setAccessNumber(data[8]);
                if (!data[9].equals(""))
                    user.setSituation(data[9]);
                user.setBondDate(data[10]);
                return user;
            }).toList();
            usuarios.forEach(System.out::println);
            return usuarios;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
