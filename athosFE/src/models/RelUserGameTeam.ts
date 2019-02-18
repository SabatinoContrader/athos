export class RelUserGameTeam{
    id: number;
    id_poi: number;
    id_game: number;
    id_team: number;
    id_user: number;
    data_fine: String;
    data_inizio: String;
    
    constructor(id: number,id_poi: number,id_game: number,id_team: number,id_user: number, data_inizio: String,data_fine: String){
        this.id = id;
        this.id_poi = id_poi;
        this.id_game = id_game;
        this.id_team = id_team;
        this.id_user = id_user;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
    }
}