package com.example.pruebaceiba.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.pruebaceiba.databinding.FragmentPostBinding
import com.example.pruebaceiba.model.ItemPost
import com.example.pruebaceiba.ui.adapter.PostAdapter
import com.example.pruebaceiba.ui.adapter.UserAdapter
import com.example.pruebaceiba.ui.viewmodels.PostViewModel


class PostFragment : Fragment() {

    private var _binding: FragmentPostBinding? = null

    private val binding get() = _binding!!

    private val args:PostFragmentArgs by navArgs()

    private val userId get() =  args.userId

    val model: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.list.adapter =PostAdapter(listOf(ItemPost(title = "la camisa negra", body = "tengo tengo la camiza negra por que negra tengo el alma")
            ,ItemPost(title = "Mercado libre", body = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum"),
            ItemPost(title = "lorem", body = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit")
        ))


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}