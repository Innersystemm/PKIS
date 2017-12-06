using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;
using System.ComponentModel.DataAnnotations.Schema;
using SoapService.EnumsAndConstants;

namespace SoapService.EntityClasses
{
    [DataContract(IsReference = true, Namespace = Constants.BindingBeans)]
    public class Region
    {
        [DataMember]
        [Required]
        [Key]
        public int RegionID { get; set; }

        [DataMember(Name = "RegionName")]
        [Required]
        [MaxLength(15)]
        public string Name { get; set; }

        [DataMember(Name = "RegionFlats")]
        public List<Flat> Flats { get; set; }
    }
}