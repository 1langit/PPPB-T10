package com.example.pppb_t10

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pppb_t10.databinding.ItemMahasiswaBinding
import kotlin.coroutines.coroutineContext

typealias OnClickMahasiswa = (Mahasiswa) -> Unit

class MahasiswaAdapter(
    private val listMahasiswa: List<Mahasiswa>,
    private val onClickMahasiswa: OnClickMahasiswa
) : RecyclerView.Adapter<MahasiswaAdapter.ItemMahasiswaViewHolder>() {

    inner class ItemMahasiswaViewHolder(private val binding: ItemMahasiswaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Mahasiswa) {
            with(binding) {
                txtName.text = data.nama
                txtIpk.text = "IPK ${data.ipk.toString()}"

                Glide.with(root)
                    .load(data.img)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .into(imgProfile)

                if (data.ipk >= 3.5) {
                    txtIpk.setTextColor(Color.WHITE)
                    txtIpk.background.setTint(Color.parseColor("#525BFF"))
                } else if (data.ipk >= 3.0) {
                    txtIpk.setTextColor(Color.BLACK)
                    txtIpk.background.setTint(Color.GREEN)
                } else if (data.ipk >= 2.5) {
                    txtIpk.setTextColor(Color.BLACK)
                    txtIpk.background.setTint(Color.YELLOW)
                } else if (data.ipk >= 2.0) {
                    txtIpk.setTextColor(Color.WHITE)
                    txtIpk.background.setTint(Color.RED)
                } else {
                    txtIpk.setTextColor(Color.WHITE)
                    txtIpk.background.setTint(Color.GRAY)
                }

                itemView.setOnClickListener {
                    onClickMahasiswa(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMahasiswaViewHolder {
        val binding = ItemMahasiswaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemMahasiswaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }

    override fun onBindViewHolder(holder: ItemMahasiswaViewHolder, position: Int) {
        holder.bind(listMahasiswa[position])
    }
}