export class Team{
    id: number;
    id_user: number;
    nome: string;
    data_creazione: string;
    attivo: boolean;

    constructor(id: number,id_user: number,  nome: string, data_creazione: string, attivo: boolean){
        this.id = id;
        this.id_user = id_user;
        this.nome = nome;
        this.data_creazione = data_creazione;
        this.attivo = attivo;
    }
}