import express from 'express'
import { Router, Request, Response } from 'express';
import {parseCsv} from "./utils/utils";
import {User} from "./entity/user";
import {PrismaClient} from "@prisma/client";

const app = express();
const route = Router()

const client = new PrismaClient()

app.use(express.json())
route.get('/', (req: Request, res: Response) => {
    res.json({ info: 'API de Usuários' })
})
app.use(route)

app.listen(3000, () => 'server running on port 3000')

route.get('/usuarios/update', (req: Request, res: Response) => {
    const users: User[] = parseCsv()
    users.forEach(async function (user) {
        user = await client.user.create({
            data: {
                ...user
            }
        })
        console.log(user)
    })
    res.send('Banco de dados atualizado!')
})

route.get('/usuarios', async (req: Request, res: Response) => {
    const users = await client.user.findMany()
    res.json(users)
})
