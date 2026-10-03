package com.lalorosas.myinvestments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            val dbHelper = InvestmentDBOpenHelper((activity as MainActivity), null)
            val name = view.findViewById<EditText>(R.id.editTextInvestmentName).text.toString()
            val amount = view.findViewById<EditText>(R.id.editTextInvestmentAmount).text.toString().toFloat()
            val investment = Investment(name, amount)
            dbHelper.insert(investment)

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            requireActivity().findViewById<FloatingActionButton>(R.id.fab).show()
        }
    }
}