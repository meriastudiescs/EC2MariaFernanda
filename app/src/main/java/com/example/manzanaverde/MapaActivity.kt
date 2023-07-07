package com.example.manzanaverde

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        // Obtener el SupportMapFragment y notificar cuando el mapa esté listo para su uso
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Configurar los marcadores
        val marker1 = MarkerOptions()
            .position(LatLng(-12.0625086,  -77.148792))
            .title("Fortaleza Real Felipe")
            .snippet("Fortaleza del siglo XVIII construida como defensa.")

        val marker2 = MarkerOptions()
            .position(LatLng(-12.0599631,-77.1463989))
            .title("Zona Monumental del Callao")
            .snippet("Zona creativa con galerías de arte moderno..")

        val marker3 = MarkerOptions()
            .position(LatLng(-12.0556177,-77.1019947))
            .title("Mallplaza Bellavista")
            .snippet("Gran centro comercial.")

        // Añadir los marcadores al mapa
        googleMap.addMarker(marker1)
        googleMap.addMarker(marker2)
        googleMap.addMarker(marker3)

        // Ajustar la cámara para mostrar todos los marcadores
        val boundsBuilder = LatLngBounds.builder()
            .include(marker1.position)
            .include(marker2.position)
            .include(marker3.position)
        val bounds = boundsBuilder.build()
        val padding = 100 // Padding en píxeles alrededor de los marcadores
        val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        googleMap.moveCamera(cameraUpdate)
    }
}
