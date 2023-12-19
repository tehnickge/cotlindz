import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.authorization.MainActivity
import com.example.authorization.R
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)
        val editTextUsername = view.findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = view.findViewById<EditText>(R.id.editTextPassword)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            // Здесь можно вызвать логику для валидации

            // Проверка, что поля не пустые и пароль "12345"
            if (username.isNotEmpty() && password == "12345") {
                (activity as MainActivity).showWelcomeFragment() // Показываем фрагмент приветствия
            } else {
                val errorMessage = "Неверное имя пользователя или пароль"
                //Snackbar.make(requireView(), errorMessage, Snackbar.LENGTH_SHORT).show()
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}