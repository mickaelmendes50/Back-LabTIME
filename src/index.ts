import express from 'express'
import { Router, Request, Response } from 'express';
import {parseCsv} from "./utils/utils";

const app = express();
const route = Router()

app.use(express.json())
route.get('/', (req: Request, res: Response) => {
    res.json({ info: 'API de Usuários' })
})
app.use(route)

app.listen(3000, () => 'server running on port 3000')

route.get('/usuarios', (req: Request, res: Response) => {
    res.json(parseCsv())
})
