
package ni.edu.uam.serviciosweb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ni.edu.uam.serviciosweb.model.UsuarioP;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPService {

    private static final String URL =
            "https://sqpvqkkdfgtzdgrjrgxs.supabase.co/rest/v1/customers";

    public List<UsuarioP> obtenerUsuarios() throws IOException, InterruptedException {

        String claveAPI = System.getenv("apiKey");

        if (claveAPI == null || claveAPI.isBlank()) {
            throw new IOException("No se ha configurado la clave de Supabase.");
        }

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .timeout(Duration.ofSeconds(15))
                .header("apikey", claveAPI)
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException(
                    "Error al obtener los usuarios. Código: " + response.statusCode()
            );
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode datos = mapper.readTree(response.body());

        if (!datos.isArray()) {
            throw new IOException("La respuesta no contiene un arreglo JSON.");
        }

        List<UsuarioP> usuarios = new ArrayList<>();

        for (JsonNode nodo : datos) {

            UsuarioP usuario = new UsuarioP();

            usuario.setId(nodo.path("id").asInt());
            usuario.setNombre(nodo.path("first_name").asText());
            usuario.setApellido(nodo.path("last_name").asText());
            usuario.setCorreo(nodo.path("email").asText());
            usuario.setTelefono(nodo.path("phone").asText());
            usuario.setFechaNacimiento(nodo.path("date_of_birth").asText());
            usuario.setPais(nodo.path("country").asText());
            usuario.setCiudad(nodo.path("city").asText());
            usuario.setDireccion(nodo.path("address").asText());
            usuario.setIngresoAnual(nodo.path("annual_income").asDouble());
            usuario.setPuntajeCrediticio(nodo.path("credit_score").asInt());
            usuario.setTieneDeuda(nodo.path("has_unpaid_debt").asBoolean());
            usuario.setMontoDeuda(nodo.path("unpaid_debt_amount").asDouble());
            usuario.setEstado(nodo.path("status").asText());
            usuario.setFechaCreacion(nodo.path("created_at").asText());
            usuario.setFechaActualizacion(nodo.path("updated_at").asText());

            usuarios.add(usuario);
        }

        return usuarios;
    }
}
