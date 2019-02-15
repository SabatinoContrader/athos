export class Game{
    id: number;
    id_creatore: number;
    nome: string;
    descrpercorso: string;
    versione: string;
    attivo: boolean;
    descr_evento:string;
    data_inizio:string;
    data_fine:string;

    constructor(id: number,id_creatore: number, nome: string, descr_percorso: string, versione: string, attivo: boolean, descr_evento:string, data_inizio:string, data_fine:string){
        this.id = id;
        this.id_creatore = id_creatore;
        this.nome = nome;
        this.descrpercorso = descr_percorso;
        this.versione = versione;
        this.attivo = attivo;
        this.descr_evento=descr_evento;
        this.data_inizio=data_inizio;
        this.data_fine=data_fine;
    }
}