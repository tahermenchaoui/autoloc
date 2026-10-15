package tn.esprit.autoloc.services;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation ajouterReservation(Reservation reservation);

    Reservation modifierReservation(Reservation reservation);

    List<Reservation> consulterReservations();

    Reservation consulterReservationById(Long idReservation);

    void supprimerReservationById(Long idReservation);
}
