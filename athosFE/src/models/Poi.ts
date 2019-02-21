export class Poi{
    
     id:number;
     attivo:boolean;
     nome:String
     latitudine:number;
     longitudine:number;

     constructor(id:number,attivo:boolean,nome:String,latitudine:number,longitudine:number){
            this.id = id;
            this.attivo= attivo;
            this.nome= nome;
            this.latitudine=latitudine;
            this.longitudine= longitudine;
     }
}