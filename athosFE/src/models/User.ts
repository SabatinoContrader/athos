export class User{
    id: number;
    username: string;
    password: string;
    role: number;
    attivo: boolean;
    data_iscrizione:string;

    constructor(id: number, username: string, password: string, role: number, attivo: boolean, data_iscrizione:string){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.attivo = attivo;
        this.data_iscrizione=data_iscrizione;
    }
}