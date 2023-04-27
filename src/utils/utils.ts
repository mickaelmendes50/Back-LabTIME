import path from "path";
import * as fs from "fs";
import { parse } from 'csv-parse';
import {User} from "../entity/user";

let users: User[] = [];

export function parseCsv(): User[] {
    const csvFilePath = path.resolve(__dirname, '../assets/usuarios.csv')
    const headers = [
        'nomeCompleto',
        'nomeSocial',
        'dataDeNascimento',
        'codigo',
        'sexo',
        'email',
        'estado',
        'municipio',
        'numeroDeAcessos',
        'situacao',
        'dataDeVinculo'
    ];

    const fileContent = fs.readFileSync(csvFilePath, { encoding: 'utf-8' });

    parse(fileContent, {
        delimiter: ',',
        columns: headers,
    }, function (error, result: User[]) {
        if (error) {
            console.error(error);
        }
        result.splice(0,1)
        users = result
    })
    return users
}
