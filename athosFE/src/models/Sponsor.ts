export class Sponsor{

    id:number;
    attivo:boolean;
    message:String;
    name:String;

    constructor(id:number, attivo:boolean,message:String,name:String){
        this.id=id;
        this.attivo=attivo;
        this.message=message;
        this.name=name;
    }
}