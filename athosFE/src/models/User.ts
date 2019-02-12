export class User{
    id: number;
    username: string;
    password: string;
    role: number;
    attivo: boolean;

    constructor(id: number, username: string, password: string, role: number, attivo: boolean){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.attivo = attivo;
    }
}