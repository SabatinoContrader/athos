export class Game{
    id: number;
    id_creatore: number;
    nome: string;
    descr_percorso: string;
    versione: string;
    attivo: boolean;

    constructor(id: number,id_creatore: number, nome: string, descr_percorso: string, versione: string, attivo: boolean){
        this.id = id;
        this.id_creatore = id_creatore;
        this.nome = nome;
        this.descr_percorso = descr_percorso;
        this.versione = versione;
        this.attivo = attivo;
    }
}